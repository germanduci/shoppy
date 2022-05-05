package com.ar.shoppy.services;

import com.ar.shoppy.models.File;
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
        public void saveFile(File file){
                fileRepo.save(file);
        }

        public List<File> fileListAll(){
                return fileRepo.findAll();
        }

        public File fileListById(String id){
                Optional<File>response= fileRepo.findById(id);
                return response.orElse(null);
        }

        public File fileListByName(String name){
                Optional<File> response = fileRepo.findByFile(name);
                return response.orElse(null);
        }
        @Transactional
        public void deleteFile(String id){
                Optional<File> response = fileRepo.findById(id);
                response.ifPresent(file->fileRepo.delete(file));
        }
}
