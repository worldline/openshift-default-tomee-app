/*
****************************************************
* Atos Worldline -- Global Platforms and Solutions

* Atos Worldline is an Atos company
* All rights reserved
*
*****************************************************
*/
package net.worldline.sdco.model;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Post {

    @Id
    @GeneratedValue
    public Integer id;

    private String author;

    private String body;

    @Column (name = "created_at")
    private Date createdAt;

    public Post() {
    }

    public Post(String author, String body) {
        this.author = author;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    @PrePersist
    private void createdAt() {
        this.createdAt = new Date();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
