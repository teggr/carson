package org.shiftleft.carson.web.boot;

import org.shiftleftautomation.svn.SVNLocation;
import org.shiftleftautomation.svn.SVNLocationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class DevelopmentConfiguration {

	public static class SVNLocationProperties {
		private String url;
		private String username;
		private String password;

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	}

	@ConfigurationProperties("vc.svn.location")
	@Bean
	public SVNLocationProperties svnLocationProperties() {
		return new SVNLocationProperties();
	}

	@Bean
	public SVNLocation svnLocation(SVNLocationProperties props) {
		return SVNLocationBuilder.create().url(props.getUrl()).credentials(props.getUsername(), props.getPassword())
				.build();
	}

}
