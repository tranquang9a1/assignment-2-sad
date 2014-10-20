package sad.teamone.service;

import sad.teamone.entity.Comment;

/**
 * Created by QuangTV on 10/19/2014.
 */
public interface CommentService {
    Comment insert(Comment Comment);
    Comment update(Comment Comment);
    Comment delete(Comment Comment);
    Comment remove(int i);
    Comment find(int id);
}