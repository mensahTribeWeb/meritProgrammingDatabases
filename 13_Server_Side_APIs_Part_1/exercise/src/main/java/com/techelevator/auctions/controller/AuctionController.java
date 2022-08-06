package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDao();
    }
    //Step Two: Implement the list() method
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Auction>list(
            @RequestParam(required = false, defaultValue = "") String title_like,
            @RequestParam(required = false, defaultValue = "0") double currentBid_lte){
        //Step Seven: Search by title and price
        if(!title_like.isEmpty() && currentBid_lte > 0){
            return dao.searchByTitleAndPrice(title_like, currentBid_lte);
        }
        //Step Five: Add searching by title
        else if(!title_like.isEmpty()) {
            return dao.searchByTitle(title_like);
        }
        //Step Six: Add searching by price
        else if (currentBid_lte > 0){
            return dao.searchByPrice(currentBid_lte);
        }
        else{return dao.list();}
    }

    //Step Three: Implement the get() action
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        return dao.get(id);
    }

    //Step Four: Implement the create() action
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Auction create(@RequestBody Auction newAuction){
        return dao.create(newAuction);
    }

}
