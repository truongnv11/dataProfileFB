package com.truongnv.model;

import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.DC;
import org.apache.jena.vocabulary.DC_11;
import org.apache.jena.vocabulary.VCARD;
import org.apache.jena.vocabulary.VCARD4;

public class JenaModel {

	public Model exportModel() {

		// create an empty Model
		Model model = ModelFactory.createDefaultModel();

		// create the resource
		Resource truongnv = model.createResource("https://www.facebook.com/truong.nexo")
				.addProperty(FOAF.familyName, "Truong").addProperty(FOAF.givenName, "Nguyen")
				.addProperty(FOAF.nick, "Nguyễn Vân Trường").addProperty(FOAF.birthday, "10/11/1998")
				.addProperty(FOAF.phone, "84977887198").addProperty(FOAF.mbox, "truongnvptit@gmail.com")
				.addProperty(VCARD4.locality, "Bắc Ninh")
				.addProperty(FOAF.schoolHomepage, model.createResource("https://www.facebook.com/pages/THPT-Y%C3%AAn-Phong-I/106286729410447"))
				.addProperty(FOAF.topic, model.createResource("https://www.facebook.com/photo.php?fbid=1809560402515991&set=a.113679542104094&type=3&theater")
						.addProperty(DC_11.creator, "https://www.facebook.com/truong.nexo")
						.addProperty(VCARD4.title, "Thời tiết hôm nay đẹp!")
						.addProperty(VCARD4.locality, "https://www.facebook.com/HoGuom.Vn"))
				.addProperty(FOAF.topic, model.createResource("https://www.facebook.com/truong.nexo/posts/1809431525862212")
						.addProperty(DC_11.creator, "https://www.facebook.com/truong.nexo")
						.addProperty(VCARD4.title, "Khai phá dữ liệu đa phương tiện"))
				.addProperty(FOAF.knows,
						model.createResource("https://www.facebook.com/cong.thieu.92", FOAF.Person)
								.addProperty(FOAF.familyName, "Cong").addProperty(FOAF.givenName, "Thieu")
								.addProperty(FOAF.nick, "Thiều Ngọc Công").addProperty(VCARD4.locality, "Vĩnh Phúc")
								.addProperty(FOAF.birthday, "01/01/1998")
								.addProperty(FOAF.schoolHomepage,
										model.createResource("https://www.facebook.com/THPT-Gia-L%E1%BB%99c-257323157622697/"))
								.addProperty(FOAF.topic, model
										.createResource("https://www.facebook.com/photo.php?fbid=2878122728961147&set=a.366476766792435&type=3&theater")
										.addProperty(DC_11.creator,
												model.createResource("https://www.facebook.com/cong.thieu.92"))
										.addProperty(VCARD4.title, "Thời tiết hôm qua đẹp và thời tiết ngày kia cũng đẹp.")
										.addProperty(VCARD4.locality, "https://www.facebook.com/pages/Khu-%C4%90%C3%B4-Th%E1%BB%8B-V%C4%83n-Qu%C3%A1n-H%C3%A0-%C4%90%C3%B4ng/159330344201280")
										)
								)
				.addProperty(FOAF.knows, model
						.createResource("https://www.facebook.com/samnv.1998", FOAF.Person)
						.addProperty(FOAF.familyName, "Sam").addProperty(FOAF.givenName, "Nguyen")
						.addProperty(FOAF.nick, "Sâm Nguyễn").addProperty(VCARD4.locality, "Thanh Oai")
						.addProperty(FOAF.birthday, "15/01/1998")
						.addProperty(FOAF.schoolHomepage, model.createResource("https://www.facebook.com/pages/THPT-Thanh-Oai-A/112224482137870"))
						.addProperty(FOAF.topic, model.createResource(
								"https://www.facebook.com/photo.php?fbid=1381520598703124&set=a.333570243498170&type=3&theater")
								.addProperty(DC_11.creator,
										model.createResource("https://www.facebook.com/samnv.1998"))
								.addProperty(VCARD4.title, "Thời tiết ngày mai đẹp hơn")
								.addProperty(VCARD4.locality, "https://www.facebook.com/pages/H%E1%BB%93-T%C3%A2y/740772509338797"))
						)
				.addProperty(FOAF.knows, model
						.createResource("https://www.facebook.com/dth.512", FOAF.Person)
						.addProperty(FOAF.familyName, "Thang").addProperty(FOAF.givenName, "Du")
						.addProperty(FOAF.nick, "Du Duc Thang")
						.addProperty(FOAF.birthday, "05/12/1998")
						.addProperty(VCARD4.locality, "Hà Nội")
						.addProperty(FOAF.schoolHomepage, "https://www.facebook.com/THPTPhanDinhPhungHaNoi/")
						.addProperty(FOAF.topic, model.createResource(
								"https://www.facebook.com/dth.512/posts/1219190075090105")
								.addProperty(DC_11.creator,
										model.createResource("https://www.facebook.com/dth.512"))
								.addProperty(VCARD4.title,
										"hi ae")
								.addProperty(VCARD4.locality, "https://www.facebook.com/places/Hoat-dong-giai-tri-tai-Tay-Ho-Ha-Noi-Vietnam/109265055761051"))
				)

		;

		// now write the model in XML form to a file
		model.setNsPrefix("foaf", "http://xmlns.com/foaf/0.1/");
		model.setNsPrefix("vcard", "http://www.w3.org/2006/vcard/ns#");
		return model;
	}

}
