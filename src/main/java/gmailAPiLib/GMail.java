//package gmailAPiLib;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.security.GeneralSecurityException;
//import java.util.Collections;
//import java.util.List;
//
//import com.google.api.client.auth.oauth2.Credential;
//import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
//import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
//import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
//import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.JsonFactory;
//import com.google.api.client.json.jackson2.JacksonFactory;
//import com.google.api.services.gmail.Gmail;
//import com.google.api.services.gmail.GmailScopes;
//import com.google.api.services.gmail.model.ListMessagesResponse;
//import com.google.api.services.gmail.model.Message;
//
//public class GMail {
//	private static final String APPLICATION_NAME = "Paragon'sapp";
//	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
//	private static final List<String> SCOPES = Collections.singletonList(GmailScopes.GMAIL_READONLY);
//	private static final String CREDENTIALS_FILE_PATH = System.getProperty("user.dir") + "\\Configs\\Creds.json";
//
//	public static void main(String[] args) throws IOException, GeneralSecurityException {
//		// Set up credentials and create the Gmail service
//		Credential credential = getCredentials();
//		Gmail service = createGmailService(credential);
//
//		// Specify the query to filter emails (e.g., by subject, sender, etc.)
//		String query = "subject:example";
//
//		// Retrieve the list of emails matching the query
//		List<Message> messages = listMessagesMatchingQuery(service, "me", query);
//
//		// Process each email message
//		for (Message message : messages) {
//			// Get the email message ID
//			String messageId = message.getId();
//
//			// Retrieve the full email message using the message ID
//			Message fullMessage = service.users().messages().get("me", messageId).execute();
//
//			// Extract the desired email fields (subject, sender, body, etc.)
//			String subject = fullMessage.getPayload().getHeaders().stream()
//					.filter(header -> header.getName().equals("Subject")).findFirst().map(header -> header.getValue())
//					.orElse("");
//			String sender = fullMessage.getPayload().getHeaders().stream()
//					.filter(header -> header.getName().equals("From")).findFirst().map(header -> header.getValue())
//					.orElse("");
//			String body = fullMessage.getSnippet();
//
//			// Process the email content as needed
//			System.out.println("Subject: " + subject);
//			System.out.println("Sender: " + sender);
//			System.out.println("Body: " + body);
//			System.out.println("=================");
//		}
//	}
//
//	private static Credential getCredentials() throws IOException, GeneralSecurityException {
//		// Load client secrets from credentials file
//		InputStream in = new FileInputStream(new File(CREDENTIALS_FILE_PATH));
//		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
//
//		// Set up authorization flow
//		NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
//		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY,
//				clientSecrets, SCOPES).build();
//
//		// Authorize and get credentials
//		Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
//
//		return credential;
//	}
//
//	private static Gmail createGmailService(Credential credential) {
//		// Build the Gmail service
//		NetHttpTransport httpTransport;
//		try {
//			httpTransport = GoogleNetHttpTransport.newTrustedTransport();
//			return new Gmail.Builder(httpTransport, JSON_FACTORY, credential).setApplicationName(APPLICATION_NAME)
//					.build();
//		} catch (GeneralSecurityException | IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	private static List<Message> listMessagesMatchingQuery(Gmail service, String userId, String query)
//			throws IOException {
//		// List messages matching the query
//		ListMessagesResponse response = service.users().messages().list(userId).setQ(query).execute();
//		return response.getMessages();
//	}
//}
