import { PrismaClient } from "@prisma/client";

const prisma = new PrismaClient();

async function main() {
  console.log("Seeding database...");

  await prisma.estudiante.deleteMany();
  await prisma.carrera.deleteMany();
  await prisma.universidad.deleteMany();
  await prisma.interes.deleteMany();
  await prisma.interesUniversidad.deleteMany();
  await prisma.universidadCarrera.deleteMany();

  const estudiantes = await Promise.all([
    prisma.estudiante.create({ data: { documento: "1001", nombre: "Ana Gómez", ciudad: "Cali" } }),
    prisma.estudiante.create({ data: { documento: "1002", nombre: "Luis Ramírez", ciudad: "Medellín" } }),
    prisma.estudiante.create({ data: { documento: "1003", nombre: "Sofía Torres", ciudad: "Bogotá" } }),
    prisma.estudiante.create({ data: { documento: "1004", nombre: "Pedro Díaz", ciudad: "Cartagena" } }),
    prisma.estudiante.create({ data: { documento: "1005", nombre: "María Castro", ciudad: "Bucaramanga" } })
  ]);

  const carreras = await Promise.all([
    prisma.carrera.create({ data: { nombre: "Ingeniería de Sistemas", area: "Tecnología" } }),
    prisma.carrera.create({ data: { nombre: "Medicina", area: "Salud" } }),
    prisma.carrera.create({ data: { nombre: "Arquitectura", area: "Diseño" } }),
    prisma.carrera.create({ data: { nombre: "Administración de Empresas", area: "Negocios" } })
  ]);

  const universidades = await Promise.all([
    prisma.universidad.create({ data: { nombre: "Universidad Nacional", ciudad: "Bogotá" } }),
    prisma.universidad.create({ data: { nombre: "Universidad de Antioquia", ciudad: "Medellín" } }),
    prisma.universidad.create({ data: { nombre: "Universidad del Valle", ciudad: "Cali" } })
  ]);

  await Promise.all([
    prisma.interes.create({ data: { idestudiante: estudiantes[0].id, idcarrera: carreras[0].idcarrera } }),
    prisma.interes.create({ data: { idestudiante: estudiantes[1].id, idcarrera: carreras[1].idcarrera } }),
    prisma.interes.create({ data: { idestudiante: estudiantes[2].id, idcarrera: carreras[2].idcarrera } }),
    prisma.interes.create({ data: { idestudiante: estudiantes[3].id, idcarrera: carreras[3].idcarrera } }),
    prisma.interes.create({ data: { idestudiante: estudiantes[4].id, idcarrera: carreras[0].idcarrera } }),
    prisma.interes.create({ data: { idestudiante: estudiantes[0].id, idcarrera: carreras[3].idcarrera } })
  ]);

  await Promise.all([
    prisma.interesUniversidad.create({ data: { idestudiante: estudiantes[0].id, iduniversidad: universidades[0].iduniversidad } }),
    prisma.interesUniversidad.create({ data: { idestudiante: estudiantes[1].id, iduniversidad: universidades[1].iduniversidad } }),
    prisma.interesUniversidad.create({ data: { idestudiante: estudiantes[2].id, iduniversidad: universidades[2].iduniversidad } }),
    prisma.interesUniversidad.create({ data: { idestudiante: estudiantes[3].id, iduniversidad: universidades[0].iduniversidad } }),
    prisma.interesUniversidad.create({ data: { idestudiante: estudiantes[4].id, iduniversidad: universidades[1].iduniversidad } })
  ]);

  await Promise.all([
    prisma.universidadCarrera.create({ data: { iduniversidad: universidades[0].iduniversidad, idcarrera: carreras[0].idcarrera } }),
    prisma.universidadCarrera.create({ data: { iduniversidad: universidades[0].iduniversidad, idcarrera: carreras[3].idcarrera } }),
    prisma.universidadCarrera.create({ data: { iduniversidad: universidades[1].iduniversidad, idcarrera: carreras[1].idcarrera } }),
    prisma.universidadCarrera.create({ data: { iduniversidad: universidades[1].iduniversidad, idcarrera: carreras[2].idcarrera } }),
    prisma.universidadCarrera.create({ data: { iduniversidad: universidades[2].iduniversidad, idcarrera: carreras[0].idcarrera } })
  ]);

  console.log("Seed completo.");
}

main()
  .catch((e) => {
    console.error(e);
    process.exit(1);
  })
  .finally(async () => {
    await prisma.$disconnect();
  });
