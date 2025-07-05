-- Clubes
INSERT INTO club_entity (id, nombre, pais, cant_hinchas) VALUES
                                                             (1, 'FC Barcelona', 'España', 1000000),
                                                             (2, 'Real Madrid', 'España', 1200000),
                                                             (3, 'Juventus', 'Italia', 800000),
                                                             (4, 'Bayern Munich', 'Alemania', 900000),
                                                             (5, 'Manchester United', 'Inglaterra', 1100000),
                                                             (6, 'Paris Saint-Germain', 'Francia', 950000);

-- Estadísticas
INSERT INTO estadisticas_entity (id, partidos_jugados, goles, pierna_habil) VALUES
                                                                                (1, 500, 200, 'Derecha'),
                                                                                (2, 600, 150, 'Derecha'),
                                                                                (3, 450, 50, 'Izquierda'),
                                                                                (4, 550, 120, 'Derecha'),
                                                                                (5, 400, 70, 'Izquierda'),
                                                                                (6, 300, 20, 'Derecha'),
                                                                                (7, 320, 10, 'Izquierda'),
                                                                                (8, 480, 85, 'Derecha'),
                                                                                (9, 510, 60, 'Derecha'),
                                                                                (10, 390, 15, 'Izquierda'),
                                                                                (11, 610, 190, 'Derecha'),
                                                                                (12, 370, 30, 'Izquierda'),
                                                                                (13, 420, 25, 'Derecha'),
                                                                                (14, 330, 5, 'Izquierda'),
                                                                                (15, 295, 0, 'Derecha'),
                                                                                (16, 530, 70, 'Izquierda'),
                                                                                (17, 460, 80, 'Derecha'),
                                                                                (18, 250, 8, 'Izquierda'),
                                                                                (19, 340, 12, 'Derecha'),
                                                                                (20, 280, 5, 'Izquierda');

-- Jugadores
INSERT INTO jugador_entity (id, nombre, posicion, debut, retiro, estadisticas_id) VALUES
                                                                                      (1, 'Lionel Messi', 'Delantero', '2004-10-16', null, 1),
                                                                                      (2, 'Cristiano Ronaldo', 'Delantero', '2002-08-14', null, 2),
                                                                                      (3, 'Andrea Pirlo', 'Mediocampista', '1995-09-01', '2017-11-05', 3),
                                                                                      (4, 'Robert Lewandowski', 'Delantero', '2008-06-07', null, 4),
                                                                                      (5, 'Neymar Jr.', 'Delantero', '2009-03-07', null, 5),
                                                                                      (6, 'Paul Pogba', 'Mediocampista', '2011-09-22', null, 6),
                                                                                      (7, 'Toni Kroos', 'Mediocampista', '2007-09-26', null, 7),
                                                                                      (8, 'Sergio Ramos', 'Defensor', '2004-10-01', null, 8),
                                                                                      (9, 'Gerard Piqué', 'Defensor', '2004-08-15', '2022-11-05', 9),
                                                                                      (10, 'Kylian Mbappé', 'Delantero', '2015-12-02', null, 10),
                                                                                      (11, 'Erling Haaland', 'Delantero', '2019-01-01', null, 11),
                                                                                      (12, 'Luka Modrić', 'Mediocampista', '2003-03-01', null, 12),
                                                                                      (13, 'Manuel Neuer', 'Arquero', '2006-08-01', null, 13),
                                                                                      (14, 'David de Gea', 'Arquero', '2009-10-01', null, 14),
                                                                                      (15, 'Ángel Di María', 'Mediocampista', '2005-10-01', null, 15),
                                                                                      (16, 'Marco Verratti', 'Mediocampista', '2010-05-01', null, 16),
                                                                                      (17, 'Joshua Kimmich', 'Defensor', '2015-03-01', null, 17),
                                                                                      (18, 'Harry Maguire', 'Defensor', '2012-09-01', null, 18),
                                                                                      (19, 'Achraf Hakimi', 'Defensor', '2017-08-01', null, 19),
                                                                                      (20, 'Raphaël Varane', 'Defensor', '2011-05-01', null, 20);

-- Relación jugador - club (Many to Many)
INSERT INTO jugador_club (jugador_id, club_id) VALUES
                                                   (1, 1), -- Messi → Barcelona
                                                   (2, 2), -- CR7 → Real Madrid
                                                   (2, 3), -- CR7 → Juventus
                                                   (3, 3), -- Pirlo → Juventus
                                                   (4, 1), -- Lewandowski → Barcelona
                                                   (5, 6), -- Neymar → PSG
                                                   (6, 3), -- Pogba → Juventus
                                                   (7, 2), -- Kroos → Real Madrid
                                                   (8, 2), -- Ramos → Real Madrid
                                                   (9, 1), -- Piqué → Barcelona
                                                   (10, 6), -- Mbappé → PSG
                                                   (11, 4), -- Haaland → Bayern (ficticio para ejemplo)
                                                   (12, 2), -- Modric → Real Madrid
                                                   (13, 4), -- Neuer → Bayern
                                                   (14, 5), -- De Gea → Man Utd
                                                   (15, 6), -- Di María → PSG
                                                   (16, 6), -- Verratti → PSG
                                                   (17, 4), -- Kimmich → Bayern
                                                   (18, 5), -- Maguire → Man Utd
                                                   (19, 6), -- Hakimi → PSG
                                                   (20, 5); -- Varane → Man Utd