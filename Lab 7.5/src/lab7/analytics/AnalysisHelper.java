/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7.analytics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lab7.entities.Comment;
import lab7.entities.Post;
import lab7.entities.User;

/**
 *
 * @author harshalneelkamal
 */
public class AnalysisHelper {
    // find user with Most Likes
    public void userWithMostLikes() {
        Map<Integer, Integer> userLikeCount = new HashMap<>();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        
        for(User user: users.values()) {
            for(Comment c: user.getComments()) {
                int likes = 0;
                if(userLikeCount.containsKey(user.getId())) {
                    likes = userLikeCount.get(user.getId());
                }
                likes += c.getLikes();
                userLikeCount.put(user.getId(), likes);
            }
        }
        int max = 0;
        int maxId = 0;
        for (int id : userLikeCount.keySet()) {
            if (userLikeCount.get(id) > max) {
                max = userLikeCount.get(id);
                maxId = id;
            }
        }
        
        System.out.println("\nUser with most likes: " + max + "\n" + users.get(maxId));
    }
    // find 5 comments which have the most likes
    public void getFiveMostLikedComment() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<>(comments.values());
        Collections.sort(commentList, new Comparator<Comment>() {
            @Override
            public int compare(Comment c1, Comment c2) {
                return c2.getLikes() - c1.getLikes();
            }
        });
        
        System.out.println("\n5 most likes comments: ");
        for (int i = 0; i < commentList.size() && i < 5; i++) {
            System.out.println(commentList.get(i));
        }
    }
    // find average number of likes per comment
    public void findAveragelikes() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<>(comments.values());
        int totalLikes = 0;
        for (Comment c: commentList) {
            totalLikes += c.getLikes();
        }
        System.out.println("\nAverage likes per comment: " + totalLikes / commentList.size());
    }
    // find top 5 inactive users based on total posts number
    public void topFiveInactiveBasedPosts() {
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        List<Post> postList = new ArrayList<>(posts.values());
        List<Integer> idList = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        for (Post p: postList) {
            int i = idList.get(p.getUserId());
            idList.set(p.getUserId(), ++i);
        }
        List<Integer> idListStore = new ArrayList<>(idList);
        Collections.sort(idList);
        System.out.println("\nTop 5 inactive users based on total posts number: ");
        for (Integer i: idList) {
            System.out.println("user id: " + idListStore.indexOf(i) + ", post number: " + i);
            idListStore.set(idListStore.indexOf(i), -1);
        }
    }
}
