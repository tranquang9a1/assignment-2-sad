package sad.teamone.service;

import sad.teamone.entity.Comment;

import java.util.List;

/**
 * Created by QuangTV on 10/19/2014.
 */
public interface CommentService {
    Boolean insert(Comment Comment);
    Boolean update(Comment Comment);
    Boolean delete(Comment Comment);
    Boolean remove(int i);
    Comment find(int id);
    List findByJobId(int jobID);
    List findToday();
    List findAll();
}
