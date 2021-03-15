package com.example.gefu.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class GefuRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("direct:gefu").to("bean:gefuFileService?method=getFiles").split(simple("${body}")).parallelProcessing(true)
				.log(LoggingLevel.INFO, "processing ---> ${body}").to("bean:gefuFileService?method=generateGefu")
				.end();
	}

}