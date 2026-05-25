import { PrismaClient } from '@prisma/client';
const prisma = new PrismaClient();

async function main() {
  console.log('estudiantes', await prisma.estudiante.count());
  console.log('carreras', await prisma.carrera.count());
  console.log('universidades', await prisma.universidad.count());
  console.log('intereses', await prisma.interes.count());
  console.log('interesUniversidad', await prisma.interesUniversidad.count());
  console.log('universidadCarrera', await prisma.universidadCarrera.count());
}

main()
  .catch((e) => console.error(e))
  .finally(async () => await prisma.$disconnect());
