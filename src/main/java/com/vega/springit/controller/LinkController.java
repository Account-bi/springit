package com.vega.springit.controller;


import com.vega.springit.domain.Link;
import com.vega.springit.repository.LinkRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/links") //mapped alle requests über links so dass in den Methoden nur noch der spezifische path angegeben weerden muss
public class LinkController {

  private LinkRepository linkRepository;


  public LinkController(LinkRepository linkRepository) {
    this.linkRepository=linkRepository;
  }

  @GetMapping("/")
  public List<Link> list(){
    return linkRepository.findAll();
  }


  //CRUD
  @PostMapping("/create")
  public Link create(@ModelAttribute Link link){
    return linkRepository.save(link);
  }

  // .. soll aufgerufen werden ... links/1 wobei 1 die id ist
  @GetMapping("/{id}")
  public Optional<Link> read(@PathVariable Long id){
    return linkRepository.findById(id);
  }

  @PutMapping("/{id}")
  public Link update(@PathVariable Long id,@ModelAttribute Link link){
    return linkRepository.save(link);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id){
    linkRepository.deleteById(id);
  }
}
