package com.anna.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.anna.lookify.models.Lookify;
import com.anna.lookify.services.LookifyService;

@Controller
public class LookifyController {
	 private final LookifyService lookifyService;
	    
	 public LookifyController(LookifyService lookifyService) {
        this.lookifyService = lookifyService;
	 }
	 
	 @RequestMapping("/")
	 public String main() {
		 return "lookify/welcome.jsp";
	 }
	 
	 
	 @RequestMapping("/dashboard")
	 public String index(Model model, @Valid @ModelAttribute("song") Lookify song) {
		 List<Lookify> songs = lookifyService.allSongs();
		 model.addAttribute("songs", songs);
	     return "/lookify/index.jsp";
	 } 
	 @RequestMapping("/songs/new")
	 public String addSong(Model model) {
		 model.addAttribute("song", new Lookify());
		 return "/lookify/addNew.jsp";	 
	 } 
	 @RequestMapping(value="/dashboard", method=RequestMethod.POST)
	 public String create(@Valid @ModelAttribute("song") Lookify song, BindingResult result) {
        if (result.hasErrors()) {
            return "/lookify/addNew.jsp";
        } else {
            lookifyService.addNew(song);
            return "redirect:/dashboard";
        }
	 }
	 @RequestMapping("/songs/new/createError")
	 public String flashMessages(RedirectAttributes redirectAttributes) {
		 redirectAttributes.addFlashAttribute("error", "Invalid entry");
		 return "redirect:/songs/new";
	 }
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	 public String destroy(@PathVariable("id") Long id) {
		 lookifyService.delete(id);
	    return "redirect:/dashboard";
	 }
	 @RequestMapping("/song/{id}")
	 public String show(@PathVariable("id") Long id, Model model){
		 Lookify song = lookifyService.showDetail(id);
	     model.addAttribute("song", song);
	     return "/lookify/show.jsp";
	 }
	 @RequestMapping(value="/search", method=RequestMethod.POST)
	 public String searchSong(@Valid @RequestParam("artist") String artist, Model model) {
		 return "redirect:/search/" + artist;
	 }
	 @RequestMapping("/search/{artist}")
	 public String searchArtist(@PathVariable ("artist") String artist,  Model model) {
		 List<Lookify> songs = lookifyService.getByArtist(artist);
		 model.addAttribute("artist", artist);
		 model.addAttribute("songs", songs);
		 return "/lookify/search.jsp";			 	 
	 }
	 @RequestMapping("/searchTopTen")
	 public String searchTop(Model model) {
		 List<Lookify> topTen = lookifyService.getTop10ByOrderByRatingDesc();
		 model.addAttribute("topTen", topTen);
		 return "lookify/topTen.jsp";
	 }	
}
