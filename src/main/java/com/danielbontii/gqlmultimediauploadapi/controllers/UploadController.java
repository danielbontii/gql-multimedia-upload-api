package com.danielbontii.gqlmultimediauploadapi.controllers;

import com.amazonaws.HttpMethod;
import com.danielbontii.gqlmultimediauploadapi.models.Asset;
import com.danielbontii.gqlmultimediauploadapi.models.AssetResponse;
import com.danielbontii.gqlmultimediauploadapi.services.impl.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;


@Controller
@RequiredArgsConstructor
public class UploadController {

    private final UploadService uploadService;

    @MutationMapping
    public AssetResponse getPresignedUrl(@Argument(name = "asset") Asset asset) {
        return uploadService.generatePreSignedUrl(asset, HttpMethod.PUT);
    }

}