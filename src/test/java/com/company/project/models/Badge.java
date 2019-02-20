package com.company.project.models;

import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;

public class Badge {

    private String badgeName;
    private int badgeId;

    public JSONObject getBadgeCreationRequestBody() {
        String randString = RandomStringUtils.randomAlphabetic(10);
        JSONObject jsonObj = new JSONObject()
                .put("name", randString);
        setBadgeName(randString);
        return jsonObj;
    }

    public void setBadgeName(String badgeName) {
        this.badgeName = badgeName;
    }

    public void setBadgeId(int badgeId) {
        this.badgeId = badgeId;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public int getBadgeId() {
        return badgeId;
    }

}
