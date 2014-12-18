package ex1;

/* ip주소가 192.168.10.100이고 서브넷 마스크(subnet mask)가 255.255.255.0 일때,
 * 네트워크 주소와 호스트 주소를 계산하여 화면에 출력하는 프로그램을 작성하시오.
 * 단, 비트연산자를 사용해서 계산해야한다.
 * 
 * */
public class Exercise1 
{
	public static void main(String[] args)
	{
		byte[] ip = {(byte)192, (byte)168, (byte)10, (byte)100};
		byte[] subnet = {(byte)255, (byte)255, (byte)255, (byte)0};
		
		byte[] nwAddress = new byte[4];	// 네트워크 주소
		byte[] hostAddress = new byte[4];	// 호스트 주소
		
		System.out.print("네트워크 주소 : ");
		
		for(int n = 0; n < ip.length; n++)
		{
			nwAddress[n] = (byte)(ip[n] & subnet[n]);		// &연산을 수행한다.
			System.out.print(nwAddress[n] >= 0? nwAddress[n] : nwAddress[n] + 256);
			System.out.print(".");
		}
		
		System.out.println();
		System.out.print("호스트 주소 : ");
		for(int n = 0; n < ip.length; n++)
		{
			hostAddress[n] = (byte)(ip[n] & ~subnet[n]);		// &연산을 수행한다.
			System.out.print(hostAddress[n] >= 0? hostAddress[n] : hostAddress[n] + 256);
			System.out.print(".");
		}
		System.out.println();
	}

}
