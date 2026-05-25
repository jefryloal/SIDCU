extends GenericRepositoryImpl<Estudiante, Long> {
    public EstudianteRepository(EntityManager em) {
        super(em, Estudiante.class);