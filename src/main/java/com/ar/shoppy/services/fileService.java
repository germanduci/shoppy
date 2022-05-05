package com.ar.shoppy.services;

import com.ar.shoppy.models.Archivo;
import com.ar.shoppy.repositories.fileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class fileService {
        @Autowired
        private fileRepository fileRepo;
        @Transactional
        public void saveFile(Archivo file){
                fileRepo.save(file);
        }

        public List<Archivo> fileListAll(){
                return fileRepo.findAll();
        }

        public Archivo fileListById(String id){
                Optional<Archivo>response= fileRepo.findById(id);
                return response.orElse(null);
        }

        public Archivo fileListByName(String name){
                Optional<Archivo> response = fileRepo.findByFile(name);
                return response.orElse(null);
        }
        @Transactional
        public void deleteFile(String id){
                Optional<Archivo> response = fileRepo.findById(id);
                response.ifPresent(file->fileRepo.delete(file));
        }
}
