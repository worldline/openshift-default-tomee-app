/*
****************************************************
* Atos Worldline -- Global Platforms and Solutions

* Atos Worldline is an Atos company
* All rights reserved
*
*****************************************************
*/
package net.worldline.sdco.servlet;

import net.worldline.sdco.business.PostController;
import net.worldline.sdco.model.Post;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import java.util.List;

@ManagedBean
@WebServlet(urlPatterns = "/blog")
public class Blog {

    @Inject
    PostController controller;

    private Post post = new Post();

    private List<Post> posts;

    @PostConstruct
    public void init(){
        posts = controller.readAll();
    }


    public String add(){
        controller.create(post);
        posts=controller.readAll();
        return "blog.xhtml";
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}