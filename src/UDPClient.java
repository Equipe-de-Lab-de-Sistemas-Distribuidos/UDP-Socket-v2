import java.io.*;
import java.net.*;
import org.jasypt.util.text.BasicTextEncryptor;


class UDPClient {
	public static void main(String args[]) throws Exception {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("1234");

        
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

		DatagramSocket clientSocket = new DatagramSocket();

		String servidor = "localhost";
		int porta = 9876;

		InetAddress IPAddress = InetAddress.getByName(servidor);

		byte[] sendData = new byte[4096];
		byte[] receiveData = new byte[4096];

		System.out.println("Digite o texto a ser enviado ao servidor: ");
		String sentence = inFromUser.readLine();
        
		sendData = sentence.getBytes();

		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, porta);

		System.out.println("Enviando pacote UDP para " + servidor + ":" + porta);
		clientSocket.send(sendPacket);																	//envia o texto normal

		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

		clientSocket.receive(receivePacket);															//recebe o texto criptografado
		System.out.println("Pacote UDP recebido...");

		String modifiedSentence = new String(receivePacket.getData());

		System.out.println("Texto recebido do servidor:" + modifiedSentence);	//criptografado

		String decryptText = textEncryptor.decrypt(modifiedSentence);									//descriptografa o texto criptografado para ver se é o mesmo
        System.out.println("TEXTO DESCRIPTOGRAFADO:" + decryptText);
		
        clientSocket.close();
		System.out.println("Socket cliente fechado!");
	}
}