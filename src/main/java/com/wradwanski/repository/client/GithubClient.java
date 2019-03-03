package com.wradwanski.repository.client;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Builder;
import lombok.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "githubClient", url = "${api.github.url}")
public interface GithubClient {

    @Cacheable("githubClient")
    @GetMapping(path = "/repos/{owner}/{repo}")
    RepositoryDetails findByOwnerAndRepo(@PathVariable String owner, @PathVariable String repo);

    @Value
    @Builder
    class RepositoryDetails {
        @JsonAlias("full_name")
        private String fullName;
        private String description;
        @JsonAlias("clone_url")
        private String cloneUrl;
        @JsonAlias("stargazers_count")
        private Long stars;
        @JsonAlias("created_at")
        private String createdAt;
    }

}
