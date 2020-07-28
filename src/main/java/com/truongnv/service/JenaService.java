package com.truongnv.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.SimpleSelector;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.vocabulary.DC_11;

import com.truongnv.model.JenaModel;
import com.truongnv.model.PersonModel;
import com.truongnv.model.PostModel;


public class JenaService {
	JenaModel jenaModel = new JenaModel();
	Model model = jenaModel.exportModel();

	public Boolean checkPerson(String uri) {
		StmtIterator iter = model.listStatements(new SimpleSelector(model.createResource(uri), DC_11.creator, (RDFNode) null) {});
		if (iter.hasNext()) { 
			return false;
		}
		return true;
	}

	public PersonModel searchPersonByUri(String uri) {
		StmtIterator iter = model.listStatements(new SimpleSelector(model.createResource(uri), null, (RDFNode) null) {});
		if (iter.hasNext()) {
			PersonModel person = new PersonModel();
			List<PersonModel> friends = new ArrayList<PersonModel>();
			List<PostModel> posts = new ArrayList<PostModel>();
			person.setUri(uri);
			while (iter.hasNext()) {
				Statement currentIter = iter.nextStatement();
				switch (currentIter.getPredicate().getLocalName()) {
				case "schoolHomepage":
					person.setSchoolHomepage(currentIter.getObject().toString());
					break;
				case "givenName":
					person.setGivenName(currentIter.getObject().toString());
					break;
				case "nick":
					person.setNick(currentIter.getObject().toString());
					break;
				case "mbox":
					person.setMbox(currentIter.getObject().toString());
					break;
				case "knows":
					PersonModel friend = searchPersonByUri(currentIter.getObject().toString());
					friends.add(friend);
					break;
				case "birthday":
					person.setBirthday(currentIter.getObject().toString());
					break;
				case "familyName":
					person.setFamilyName(currentIter.getObject().toString());
					break;
				case "phone":
					person.setPhone(currentIter.getObject().toString());
					break;
				case "locality":
					person.setLocality(currentIter.getObject().toString());
					break;
				case "topic":
					PostModel post = searchPostModelByUri(currentIter.getObject().toString());
					posts.add(post);
					break;
				default:
					break;
				}
			}
			person.setPosts(posts);
			person.setFriends(friends);
			return person;
		} else {
			return null;
		}

	}
	
	public PostModel searchPostModelByUri(String uri) {
		StmtIterator iter = model.listStatements(new SimpleSelector(model.createResource(uri), null, (RDFNode) null) {});
		if (iter.hasNext()) {
			PostModel post = new PostModel();
			post.setUri(uri);
			while (iter.hasNext()) {
				Statement currentIter = iter.nextStatement();
				
				switch (currentIter.getPredicate().getLocalName()) {
				case "title":
					post.setTitle(currentIter.getObject().toString());
					break;
				case "locality":
					post.setLocality(currentIter.getObject().toString());
					break;
				case "creator":
					post.setCreator(currentIter.getObject().toString());
					break;
				default:
					break;
				}
			}
			return post;
		} else {
			return null;
		}
	}

}
