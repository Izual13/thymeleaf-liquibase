package com.example.thymeleafLiquibase;

import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Repository;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Repository
public class FilesDAO {

    @Autowired
    GridFsOperations gridFsOperations;


    public byte[] findById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id")
                                  .is(id));
        GridFSDBFile gridFSFile = gridFsOperations.findOne(query);
        if (gridFSFile == null) {
            return null;
        }

        try (InputStream is = gridFSFile.getInputStream()) {
            return IOUtils.toByteArray(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    String save(FileDTO file) {
        try (InputStream inputStream = new ByteArrayInputStream(file.getBytes())) {
            GridFSFile store = gridFsOperations.store(inputStream, file.getName());
            return store.getId() + "";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
