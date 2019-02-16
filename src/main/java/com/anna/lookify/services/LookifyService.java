package com.anna.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anna.lookify.models.Lookify;
import com.anna.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	private LookifyRepository lookifyRepository;
	
	public LookifyService(LookifyRepository lookifyRepository) {
		this.lookifyRepository = lookifyRepository;	
	}
	
	public List<Lookify> allSongs() {
        return lookifyRepository.findAll();
    }
	
	public Lookify addNew(Lookify song) {
        return lookifyRepository.save(song);
    }
	
	public Lookify showDetail(Long id) {
        Optional<Lookify> song = lookifyRepository.findById(id);
        if(song.isPresent()) {
            return song.get();
        } else {
            return null;
        }
    }
	public void delete(Long id) {
		lookifyRepository.deleteById(id);		
	}
	public List<Lookify> getByArtist(String artist){
		return lookifyRepository.findByArtist(artist);
	}
	public List<Lookify> getTop10ByOrderByRatingDesc(){
		return lookifyRepository.findTop10ByOrderByRatingDesc();
	}
	
}
