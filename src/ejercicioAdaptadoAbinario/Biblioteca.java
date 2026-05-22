package ejercicioAdaptadoAbinario;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

	final static String RUTA = "Ficheros//biblioteca.dat";
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int opcion;
		List<Artista> artistas = new ArrayList<Artista>();
		
		try {
			artistas = leerfichero(RUTA);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		do {
			System.out.println("--------");
			System.out.println("--MENU--");
			System.out.println("--------");
			System.out.println("0)Salir");
			System.out.println("1)Crear artista");
			System.out.println("2)Crear Album");
			System.out.println("3)Borrar el album de un artista");
			System.out.println("4)Crear Cancion");
			System.out.println("5)Ver playlist favoritas");
			System.out.println("6)Calcular duracion");
			System.out.println("7)Eliminar cancion de favoritas");
			System.out.println("8)Borrar caancion");
			System.out.println("9)Mostrar informacion");
			System.out.println("Introduce una opcion");
			opcion = teclado.nextInt();
			teclado.nextLine();
			
			switch (opcion) {
			case 0:
				System.out.println("Saliendo de la Biblioteca...");
				break;
			case 1:
				System.out.println("Annadir artista: ");
				System.out.println();
				System.out.println("Dime el nombre del artista");
				String nombre = teclado.nextLine();
				if(buscarArtista(nombre, artistas) != null) {
					System.out.println("El artista ya esta añadido");
				}else {
					System.out.println("Dime su nacionalidad");
					String nacionalidad = teclado.nextLine();
					Artista annadirArtista = new Artista(nombre, nacionalidad);
					artistas.add(annadirArtista);
					try {
						escribirFichero(RUTA, artistas);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("El artista esta añadido correctamenta");
				}
				break;
			case 2:
				System.out.println("Annadir album");
				System.out.println();
				System.out.println("Dime el nombre del artista");
				nombre = teclado.nextLine();
				Artista artistaBuscado = buscarArtista(nombre, artistas);
				if(artistaBuscado != null) {
					System.out.println("Introduce el nombre del album");
					String nombreAlbum = teclado.nextLine();
					Album buscarAlbum = artistaBuscado.buscarAlbum(nombreAlbum);
					
					if (buscarAlbum != null) {
						System.out.println("El album ya esta asociado al artista");
					}else {
						Album nuevoAlbum = new Album(nombreAlbum);
						artistaBuscado.getAlbumes().add(nuevoAlbum);
						try {
							escribirFichero(RUTA, artistas);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}catch (NullPointerException e) {
							System.out.println(e);
						}
						System.out.println("Album annadido al artista");
					}
				}else {
					System.out.println("El artista no existe");
				}

				break;
			case 3:
				System.out.println("Borrar album");
				System.out.println();
				
				System.out.println("Dime el nombre del artista");
				nombre = teclado.nextLine();
				artistaBuscado = buscarArtista(nombre, artistas);
				if(artistaBuscado != null) {
					System.out.println("Introduce el nombre del album");
					String nombreAlbum = teclado.nextLine();
					Album buscarAlbum = artistaBuscado.buscarAlbum(nombreAlbum);
					
					if(buscarAlbum != null) {
						artistaBuscado.getAlbumes().remove(buscarAlbum);
						try {
							escribirFichero(RUTA, artistas);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Album eliminado completamente");
					}else {
						System.out.println("El album no existe");
					}
				}else {
					System.out.println("El artista no existe");
				}
				break;
			case 4:
				System.out.println("Annadir Cancion");
				System.out.println();
				
				System.out.println("Dime el nombre del artista");
				nombre = teclado.nextLine();
				artistaBuscado = buscarArtista(nombre, artistas);
				if(artistaBuscado != null) {
					System.out.println("Introduce el nombre del album");
					String nombreAlbum = teclado.nextLine();
					Album buscarAlbum = artistaBuscado.buscarAlbum(nombreAlbum);
					if(buscarAlbum != null) {
						System.out.println("Introduce el nombre de la cancion");
						String nombreCan = teclado.nextLine();
						System.out.println("Introduce la duracion de la cancion");
						int duracion = teclado.nextInt();
						teclado.nextLine();
						System.out.println("Introduce el genero de la cancion");
						String genero = teclado.nextLine();
						System.out.println("Elige si es favorita o no ");
						boolean favorita = teclado.nextBoolean();
						Cancion cancionBuscar = buscarAlbum.buscarCancion(nombre);
						if(cancionBuscar != null) {
							System.out.println("La cancion ya esta annadida");
						}else {
							Cancion nuevaCancion = new Cancion(nombreCan, duracion, genero, favorita);
							buscarAlbum.getCanciones().add(nuevaCancion);
							try {
								escribirFichero(RUTA, artistas);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("Cancion annadida");
						}
;					}else {
						System.out.println("El album no existe");
					}
					
				}else {
					System.out.println("El artista no existe");
				}
				break;
			case 5:
				System.out.println("Playlist Favoritas");
				System.out.println();

				boolean hayFavoritas = false;

				for (Artista artista : artistas) {

				    for (Album album : artista.getAlbumes()) {

				        for (Cancion cancion : album.getCanciones()) {

				            if (cancion.isFavoritas()) {
				                System.out.println("Artista: " + artista.getNombre());
				                System.out.println("Álbum: " + album.getNombre());
				                System.out.println("Canción: " + cancion.getTitulo());
				                System.out.println("Duración: " + cancion.getDuracion());
				                System.out.println("----------------------");
				                hayFavoritas = true;
				            }
				        }
				    }
				}

				if (!hayFavoritas) {
				    System.out.println("No hay canciones en Favoritas.");
				}
				break;
			case 6:
				System.out.println("Calculo de segundos de canciones del artista elegido");
				System.out.println();
				
				System.out.println("Dime el nombre del artista");
				nombre = teclado.nextLine();
				artistaBuscado = buscarArtista(nombre, artistas);
				if(artistaBuscado != null) {
					int contadorSec = 0;
						for (Album al : artistaBuscado.getAlbumes()) {
							for (Cancion c : al.getCanciones()) {
								contadorSec += c.getDuracion();
							}
						}
					
					System.out.println("La duracion de las canciones de " + artistaBuscado.getNombre() + " es:  " + contadorSec + " segundos");
					
				}else {
					System.out.println("El artista no existe");
				}
				break;
			case 7:
				System.out.println("Eliminar Cancion de favoritas: ");
				System.out.println();
				
					System.out.println("Dime el nombre del artista");
					nombre = teclado.nextLine();
					artistaBuscado = buscarArtista(nombre, artistas);
					if(artistaBuscado != null) {
						System.out.println("Introduce el nombre del album");
						String nombreAlbum = teclado.nextLine();
						Album buscarAlbum = artistaBuscado.buscarAlbum(nombreAlbum);
						if(buscarAlbum != null) {
							System.out.println("Introduce el nombre de la cancion");
							String nombreCan = teclado.nextLine();
							Cancion cancionBuscar = buscarAlbum.buscarCancion(nombreCan);
							if(cancionBuscar != null) {
								if(cancionBuscar.isFavoritas()) {
								cancionBuscar.setFavoritas(false);
								try {
									escribirFichero(RUTA, artistas);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								System.out.println("Cancion Eliminada de favoritas");
								}else {
									System.out.println("Esta cancion no esta en favoritas");
								}
							}else {

								System.out.println("No existe la cancion");
							}
	;					}else {
							System.out.println("El album no existe");
						}
						
					}else {
						System.out.println("El artista no existe");
					}
				break;
			case 8:
				System.out.println("Borrar Cancion: ");
				System.out.println();
				
				System.out.println("Dime el nombre del artista");
				nombre = teclado.nextLine();
				artistaBuscado = buscarArtista(nombre, artistas);
				if(artistaBuscado != null) {
					System.out.println("Introduce el nombre del album");
					String nombreAlbum = teclado.nextLine();
					Album buscarAlbum = artistaBuscado.buscarAlbum(nombreAlbum);
					if(buscarAlbum != null) {
						System.out.println("Introduce el nombre de la cancion");
						String nombreCan = teclado.nextLine();
						Cancion cancionBuscar = buscarAlbum.buscarCancion(nombreCan);
						if(cancionBuscar != null) {
							buscarAlbum.getCanciones().remove(cancionBuscar);
							try {
								escribirFichero(RUTA, artistas);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("Cancion Eliminada");
						}else {

							System.out.println("No existe la cancion");
						}
;					}else {
						System.out.println("El album no existe");
					}
					
				}else {
					System.out.println("El artista no existe");
				}
				break;
			case 9:
				try {
					artistas = leerfichero("Ficheros//biblioteca.dat");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(artistas);
				break;

			default:
				System.out.println("Opcion no reconocida");
				break;
			}
		}while (opcion != 0);

	}
	public static boolean hayFavoritas(List<Artista> artistas) {

	    for (Artista artista : artistas) {
	        for (Album album : artista.getAlbumes()) {
	            for (Cancion cancion : album.getCanciones()) {

	                if (cancion.isFavoritas()) {
	                    return true;
	                }
	            }
	        }
	    }

	    return false;
	}
	public static Artista buscarArtista (String nombre, List<Artista> artistas) {
		for(Artista a : artistas) {
			if(a.getNombre().equals(nombre)) {
				return a;
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Artista> leerfichero (String ruta) throws ClassNotFoundException, IOException{
		List<Artista> artistas = new ArrayList<Artista>();
		try(FileInputStream fis = new FileInputStream(ruta);
				ObjectInputStream ois = new ObjectInputStream(fis)){
			artistas = (List<Artista>) ois.readObject();
		}
		return artistas;
	}
	public static void escribirFichero (String ruta, List<Artista> artistas) throws IOException {
		try(FileOutputStream fos = new FileOutputStream(ruta);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(artistas);
		}
	}

}
