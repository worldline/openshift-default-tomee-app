/*
****************************************************
* Atos Worldline -- Global Platforms and Solutions

* Atos Worldline is an Atos company
* All rights reserved
*
*****************************************************
*/
package net.worldline.sdco.business;

import net.worldline.sdco.model.Post;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class PostController {

    @PersistenceContext
    private EntityManager em;

    public void create(Post post){
        em.persist(post);
    }

    public List<Post> readAll(){
        Query q = em.createQuery("Select p From Post p Order by p.createdAt desc");
        return q.getResultList();
    }

}
