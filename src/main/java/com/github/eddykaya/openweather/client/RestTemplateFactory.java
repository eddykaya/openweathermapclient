package com.github.eddykaya.openweather.client;

import java.net.InetSocketAddress;
import java.net.Proxy;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

class RestTemplateFactory {

	RestTemplateFactory() {
	}

	SimpleClientHttpRequestFactory getRequestFactoryWithProxyAuth(final String httpProxyHost,
		final int httpProxyPort, final String httpProxyUser, final String httpProxyPass) {
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();

		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(
			new AuthScope(httpProxyHost, httpProxyPort),
			new UsernamePasswordCredentials(httpProxyUser, httpProxyPass));

		HttpHost myProxy = new HttpHost(httpProxyHost, httpProxyPort);
		HttpClientBuilder clientBuilder = HttpClientBuilder.create();

		clientBuilder.setProxy(myProxy).setDefaultCredentialsProvider(credsProvider).disableCookieManagement();

		HttpClient httpClient = clientBuilder.build();
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setHttpClient(httpClient);

		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(httpProxyHost, httpProxyPort));
		requestFactory.setProxy(proxy);
		return requestFactory;
	}
}