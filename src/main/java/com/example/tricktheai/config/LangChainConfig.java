package com.example.tricktheai.config;

import dev.langchain4j.http.client.jdk.JdkHttpClient;
import dev.langchain4j.http.client.jdk.JdkHttpClientBuilder;
import dev.langchain4j.http.client.spring.restclient.SpringRestClientBuilderFactory;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.store.memory.chat.InMemoryChatMemoryStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;

@Configuration
public class LangChainConfig {
    @Value("${openai.api-key}")
    private String openAiApiKey;

    java.net.http.HttpClient.Builder httpClientBuilder = HttpClient.newBuilder();

    JdkHttpClientBuilder jdkHttpClientBuilder = JdkHttpClient.builder()
            .httpClientBuilder(httpClientBuilder);

    @Bean
    public ChatLanguageModel chatLanguageModel() {
        return OpenAiChatModel.builder()
                .apiKey(openAiApiKey)
                .modelName("gpt-4o")
                .httpClientBuilder(jdkHttpClientBuilder)
                .build();
    }

    @Bean
    public ChatMemory chatMemory(){
        return MessageWindowChatMemory.withMaxMessages(20);
    }
}
