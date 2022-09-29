import java.io.*;
import java.net.*;
import org.jasypt.util.text.BasicTextEncryptor;

class ClientUDP {
	public static void main(String args[]) throws Exception {
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        	textEncryptor.setPassword("senha");

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

		DatagramSocket clientSocket = new DatagramSocket();

		int porta = Integer.parseInt(args[1]);

		InetAddress IPAddress = InetAddress.getByName(args[0]);

		byte[] sendData = new byte[4096];
		byte[] receiveData = new byte[4096];

		System.out.println("Digite o texto a ser enviado ao servidor: ");
		String sentence = inFromUser.readLine();
		sendData = sentence.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, porta);

		System.out.println("Enviando pacote UDP para " + args[0] + ":" + porta);
		clientSocket.send(sendPacket);

		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

		clientSocket.receive(receivePacket);
		System.out.println("Pacote UDP recebido...");

		String modifiedSentence = new String(receivePacket.getData());

		System.out.println("Texto recebido do servidor:" + modifiedSentence);

		String decryptText = textEncryptor.decrypt(modifiedSentence);
        	System.out.println("TEXTO DESCRIPTOGRAFADO:" + decryptText);

		clientSocket.close();
		System.out.println("Socket cliente fechado!");
	}
}
