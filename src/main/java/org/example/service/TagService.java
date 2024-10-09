package org.example.service;

import org.example.domaine.Tag;
import org.example.repository.Tagrepository;

import java.util.List;

public class TagService {

    private Tagrepository tagrepository;

    public TagService (){
        this.tagrepository = new Tagrepository();
    }

    public void saveTag(Tag tag){
        tagrepository.save(tag);
    }

    public List<Tag> getAlltags(){
        return tagrepository.getAll();
    }

    public void deletetag(Long id){
        tagrepository.delete(id);
    }


}
