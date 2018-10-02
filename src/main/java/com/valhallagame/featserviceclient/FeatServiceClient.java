package com.valhallagame.featserviceclient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.valhallagame.common.AbstractServiceClient;
import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestResponse;
import com.valhallagame.featserviceclient.message.AddFeatParameter;
import com.valhallagame.featserviceclient.message.GetFeatsParameter;
import com.valhallagame.featserviceclient.message.RemoveFeatParameter;

import java.io.IOException;
import java.util.List;

public class FeatServiceClient extends AbstractServiceClient {
	private static FeatServiceClient featServiceClient;

	private FeatServiceClient() {
		serviceServerUrl = "http://localhost:" + DefaultServicePortMappings.FEAT_SERVICE_PORT;
	}

	public static void init(String serviceServerUrl) {
		FeatServiceClient client = get();
		client.serviceServerUrl = serviceServerUrl;
	}

	public static FeatServiceClient get() {
		if (featServiceClient == null) {
			featServiceClient = new FeatServiceClient();
		}

		return featServiceClient;
	}

	public RestResponse<List<String>> getFeats(GetFeatsParameter input) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/feat/get-feats", input,
				new TypeReference<List<String>>() {
				});
	}

	public RestResponse<String> addFeat(AddFeatParameter input) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/feat/add-feat", input, String.class);
	}

	public RestResponse<String> removeFeat(RemoveFeatParameter input) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/feat/remove-feat", input, String.class);
	}
}
