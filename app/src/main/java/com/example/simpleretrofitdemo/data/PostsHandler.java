package com.example.simpleretrofitdemo.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 7/8/2015.
 */

public class PostsHandler {

    @SerializedName("items")
    @Expose
    private List<Item> items = new ArrayList<Item>();
    @SerializedName("has_more")
    @Expose
    private Boolean hasMore;
    @SerializedName("quota_max")
    @Expose
    private Integer quotaMax;
    @SerializedName("quota_remaining")
    @Expose
    private Integer quotaRemaining;

    /**
     * @return The items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * @param items The items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * @return The hasMore
     */
    public Boolean getHasMore() {
        return hasMore;
    }

    /**
     * @param hasMore The has_more
     */
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    /**
     * @return The quotaMax
     */
    public Integer getQuotaMax() {
        return quotaMax;
    }

    /**
     * @param quotaMax The quota_max
     */
    public void setQuotaMax(Integer quotaMax) {
        this.quotaMax = quotaMax;
    }

    /**
     * @return The quotaRemaining
     */
    public Integer getQuotaRemaining() {
        return quotaRemaining;
    }

    /**
     * @param quotaRemaining The quota_remaining
     */
    public void setQuotaRemaining(Integer quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
    }

    public class Item {

        @SerializedName("tags")
        @Expose
        private List<String> tags = new ArrayList<String>();
        @SerializedName("owner")
        @Expose
        private Owner owner;
        @SerializedName("is_answered")
        @Expose
        private Boolean isAnswered;
        @SerializedName("view_count")
        @Expose
        private Integer viewCount;
        @SerializedName("answer_count")
        @Expose
        private Integer answerCount;
        @SerializedName("score")
        @Expose
        private Integer score;
        @SerializedName("last_activity_date")
        @Expose
        private Integer lastActivityDate;
        @SerializedName("creation_date")
        @Expose
        private Integer creationDate;
        @SerializedName("question_id")
        @Expose
        private Integer questionId;
        @SerializedName("link")
        @Expose
        private String link;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("last_edit_date")
        @Expose
        private Integer lastEditDate;
        @SerializedName("accepted_answer_id")
        @Expose
        private Integer acceptedAnswerId;

        /**
         * @return The tags
         */
        public List<String> getTags() {
            return tags;
        }

        /**
         * @param tags The tags
         */
        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        /**
         * @return The owner
         */
        public Owner getOwner() {
            return owner;
        }

        /**
         * @param owner The owner
         */
        public void setOwner(Owner owner) {
            this.owner = owner;
        }

        /**
         * @return The isAnswered
         */
        public Boolean getIsAnswered() {
            return isAnswered;
        }

        /**
         * @param isAnswered The is_answered
         */
        public void setIsAnswered(Boolean isAnswered) {
            this.isAnswered = isAnswered;
        }

        /**
         * @return The viewCount
         */
        public Integer getViewCount() {
            return viewCount;
        }

        /**
         * @param viewCount The view_count
         */
        public void setViewCount(Integer viewCount) {
            this.viewCount = viewCount;
        }

        /**
         * @return The answerCount
         */
        public Integer getAnswerCount() {
            return answerCount;
        }

        /**
         * @param answerCount The answer_count
         */
        public void setAnswerCount(Integer answerCount) {
            this.answerCount = answerCount;
        }

        /**
         * @return The score
         */
        public Integer getScore() {
            return score;
        }

        /**
         * @param score The score
         */
        public void setScore(Integer score) {
            this.score = score;
        }

        /**
         * @return The lastActivityDate
         */
        public Integer getLastActivityDate() {
            return lastActivityDate;
        }

        /**
         * @param lastActivityDate The last_activity_date
         */
        public void setLastActivityDate(Integer lastActivityDate) {
            this.lastActivityDate = lastActivityDate;
        }

        /**
         * @return The creationDate
         */
        public Integer getCreationDate() {
            return creationDate;
        }

        /**
         * @param creationDate The creation_date
         */
        public void setCreationDate(Integer creationDate) {
            this.creationDate = creationDate;
        }

        /**
         * @return The questionId
         */
        public Integer getQuestionId() {
            return questionId;
        }

        /**
         * @param questionId The question_id
         */
        public void setQuestionId(Integer questionId) {
            this.questionId = questionId;
        }

        /**
         * @return The link
         */
        public String getLink() {
            return link;
        }

        /**
         * @param link The link
         */
        public void setLink(String link) {
            this.link = link;
        }

        /**
         * @return The title
         */
        public String getTitle() {
            return title;
        }

        /**
         * @param title The title
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * @return The lastEditDate
         */
        public Integer getLastEditDate() {
            return lastEditDate;
        }

        /**
         * @param lastEditDate The last_edit_date
         */
        public void setLastEditDate(Integer lastEditDate) {
            this.lastEditDate = lastEditDate;
        }

        /**
         * @return The acceptedAnswerId
         */
        public Integer getAcceptedAnswerId() {
            return acceptedAnswerId;
        }

        /**
         * @param acceptedAnswerId The accepted_answer_id
         */
        public void setAcceptedAnswerId(Integer acceptedAnswerId) {
            this.acceptedAnswerId = acceptedAnswerId;
        }

        /**
         * Convenience method to get tags list as string.
         */
        public String getTagsAsString() {
            String tagString = "";
            if (tags.size() == 1) {
                return tags.get(0);
            }
            for (String tag : tags) {
                if (tag.equals(tags.get(tags.size() - 1))) {
                    tagString = tagString.concat(tag);
                } else {
                    tagString = tagString.concat(tag + " | ");
                }
            }
            return tagString;
        }

    }

    public class Owner {

        @SerializedName("reputation")
        @Expose
        private Integer reputation;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("user_type")
        @Expose
        private String userType;
        @SerializedName("accept_rate")
        @Expose
        private Integer acceptRate;
        @SerializedName("profile_image")
        @Expose
        private String profileImage;
        @SerializedName("display_name")
        @Expose
        private String displayName;
        @SerializedName("link")
        @Expose
        private String link;

        /**
         * @return The reputation
         */
        public Integer getReputation() {
            return reputation;
        }

        /**
         * @param reputation The reputation
         */
        public void setReputation(Integer reputation) {
            this.reputation = reputation;
        }

        /**
         * @return The userId
         */
        public Integer getUserId() {
            return userId;
        }

        /**
         * @param userId The user_id
         */
        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        /**
         * @return The userType
         */
        public String getUserType() {
            return userType;
        }

        /**
         * @param userType The user_type
         */
        public void setUserType(String userType) {
            this.userType = userType;
        }

        /**
         * @return The acceptRate
         */
        public Integer getAcceptRate() {
            return acceptRate;
        }

        /**
         * @param acceptRate The accept_rate
         */
        public void setAcceptRate(Integer acceptRate) {
            this.acceptRate = acceptRate;
        }

        /**
         * @return The profileImage
         */
        public String getProfileImage() {
            return profileImage;
        }

        /**
         * @param profileImage The profile_image
         */
        public void setProfileImage(String profileImage) {
            this.profileImage = profileImage;
        }

        /**
         * @return The displayName
         */
        public String getDisplayName() {
            return displayName;
        }

        /**
         * @param displayName The display_name
         */
        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        /**
         * @return The link
         */
        public String getLink() {
            return link;
        }

        /**
         * @param link The link
         */
        public void setLink(String link) {
            this.link = link;
        }

    }

}