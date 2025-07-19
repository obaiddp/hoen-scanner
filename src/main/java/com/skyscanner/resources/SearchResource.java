package com.skyscanner.resources;

import com.codahale.metrics.annotation.Timed;
import com.skyscanner.core.Search;
import com.skyscanner.core.SearchResult;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SearchResource {

    List<SearchResult> searchResults;
    public SearchResource(List<SearchResult> searchResults) {   this.searchResults = searchResults; }

    @POST
    public List<SearchResult> search(@NotNull @Valid Search search) {
        List<SearchResult> response = new ArrayList<>();

        for (SearchResult result : searchResults) {
            if (result.getCity().equalsIgnoreCase(search.getCity())) {
                response.add(result);
            }
        }
        return response;
    }
}