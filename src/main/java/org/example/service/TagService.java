package org.example.service;

import org.example.domaine.Tag;
import org.example.repository.TagRepository;

import java.util.List;

public class TagService {

    private TagRepository tagRepository;

    public TagService (){
        this.tagRepository = new TagRepository();
    }

    public void saveTag(Tag tag){
        tagRepository.save(tag);
    }

    public List<Tag> getAlltags(){
        return tagRepository.getAll();
    }

    public void deletetag(Long id){
        tagRepository.delete(id);
    }

    public Tag findTagById(Long id) {
        return tagRepository.findById(id);
    }


}
