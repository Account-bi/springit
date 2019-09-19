package com.vega.springit.controller;


import com.vega.springit.domain.Link;
import com.vega.springit.domain.Vote;
import com.vega.springit.repository.LinkRepository;
import com.vega.springit.repository.VoteRepository;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteController {

      private VoteRepository voteRepository;
      private LinkRepository linkRepository;

  public VoteController(VoteRepository voteRepository, LinkRepository linkRepository) {
    this.voteRepository = voteRepository;
    this.linkRepository = linkRepository;
  }

  // http://localhost:8080/vote/link/1/direction/-1/votecount/5
  @GetMapping("/vote/link/{linkID}/{direction}/votecount/{voteCount}")
  public int vote(@PathVariable Long linkkID, @PathVariable short direction, @PathVariable int voteCount){

    Optional<Link> optionalLink = linkRepository.findById(linkkID);
    if (optionalLink.isPresent()){
      Link link = optionalLink.get();
      Vote vote = new Vote(direction, link);
      voteRepository.save(vote);
      int updatedVoteCount =  voteCount + direction;
      link.setVoteCount(updatedVoteCount);
      linkRepository.save(link);
      return updatedVoteCount;
    }
    return voteCount;
  }
}
