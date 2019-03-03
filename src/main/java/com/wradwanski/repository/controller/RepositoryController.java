package com.wradwanski.repository.controller;

import com.wradwanski.repository.client.GithubClient;
import com.wradwanski.repository.client.GithubClient.RepositoryDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/repositories")
public class RepositoryController {
    private final GithubClient githubClient;

    @GetMapping("/{owner}/{repository-name}")
    RepositoryDetails findByOwnerAndRepositoryName(@PathVariable("owner") String owner,
                                                   @PathVariable("repository-name") String repo) {
        return githubClient.findByOwnerAndRepo(owner, repo);
    }

}
