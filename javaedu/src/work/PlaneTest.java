package work;

public class PlaneTest {

	public static void main(String[] args) {
		Plane [] planes = new Plane[2];
		
		planes[0] = new Airplane("L747",1000);
		planes[1] = new Cargoplane("C40",1000);
		
		printInfo(planes);
		
		System.out.println("\n[100 운항]");
		for(Plane data : planes) {
			data.filght(100);
		}	
		printInfo(planes);
		
		System.out.println("\n[200 주유]");
		for(Plane data : planes) {
			data.refuel(200);
		}	
		printInfo(planes);
		
	}
	
	public static void printInfo(Plane[] list) {
		System.out.printf("Plane\tfuelSize\n");
		System.out.println("--------------------");
		for(Plane data : list) {
			System.out.println(data.getPlaneName()+"\t"+data.getFuelSize());
		}
		
	}

}
