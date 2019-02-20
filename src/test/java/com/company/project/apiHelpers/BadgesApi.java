package com.company.project.apiHelpers;

import com.company.project.dataProviders.PropertiesReader;
import com.company.project.models.Badge;
import io.restassured.response.Response;

import java.util.List;

public class BadgesApi extends BaseApi{

    private final String baseApiURL = PropertiesReader.getInstance().getBaseApiURL();

    private final String deleteBadgeEndpoint = baseApiURL + "badge/delete/";
    private final String addBadgeEndpoint = baseApiURL + "badge/add";
    private final String loginEndpoint = baseApiURL + "user/adminLogin";
    private final String getBadgesEndpoint = baseApiURL + "badge/list";

    public void addBadge(String login, String password, Badge badge) {
        String authToken = returnAuthToken(loginEndpoint, login, password);
        Response response = addRequest(addBadgeEndpoint, badge.getBadgeCreationRequestBody(), authToken);
        badge.setBadgeName(response.path("name").toString());
        badge.setBadgeId(Integer.parseInt(response.path("id").toString()));
    }

    public void deleteBadge(String login, String password, Badge badge) {
        String authToken = returnAuthToken(loginEndpoint, login, password);
        List<Integer> badgesIds = getRequest(getBadgesEndpoint, authToken).path("id");
        if (badgesIds.contains(badge.getBadgeId())) {
            deleteRequest(deleteBadgeEndpoint, badge.getBadgeId(), authToken);
        }
    }
}
