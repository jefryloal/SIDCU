import { PrismaClient } from "@prisma/client";

const prisma = new PrismaClient();

async function main() {
  // Ejemplo: listar todos los estudiantes
  const estudiantes = await prisma.estudiante.findMany();
  console.log("Estudiantes:", estudiantes);

  // Ejemplo: crear un estudiante nuevo
  const nuevoEstudiante = await prisma.estudiante.create({
    data: {
      documento: "12345678",
      nombre: "Juan Pérez",
      ciudad: "Bogotá"
    }
  });
  console.log("Estudiante creado:", nuevoEstudiante);
}

main()
  .catch((e) => {
    console.error(e);
  })
  .finally(async () => {
    await prisma.$disconnect();
  });
