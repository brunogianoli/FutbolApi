-- Clubes
INSERT INTO club_entity (id, nombre, pais, cant_hinchas) VALUES
(1, 'FC Barcelona', 'España', 1000000),
(2, 'Real Madrid', 'España', 1200000),
(3, 'Juventus', 'Italia', 800000);

-- Estadísticas
INSERT INTO estadisticas_entity (id, partidos_jugados, goles, pierna_habil) VALUES
(1, 500, 200, 'Derecha'),
(2, 600, 150, 'Derecha'),
(3, 450, 50, 'Izquierda');

-- Jugadores
INSERT INTO jugador_entity (id, nombre, posicion, debut, retiro, estadisticas_id) VALUES
(1, 'Lionel Messi', 'Delantero', '2004-10-16', null, 1),
(2, 'Cristiano Ronaldo', 'Delantero', '2002-08-14', null, 2),
(3, 'Andrea Pirlo', 'Mediocampista', '1995-09-01', '2017-11-05', 3);

-- Relación many-to-many jugador - club
INSERT INTO jugador_club (jugador_id, club_id) VALUES
(1, 1), -- Messi → Barcelona
(2, 2), -- CR7 → Real Madrid
(2, 3), -- CR7 → Juventus
(3, 3); -- Pirlo → Juventus
