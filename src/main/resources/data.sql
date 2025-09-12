-- CRAGS --
INSERT INTO crag (name, city, postal_code, lat, lon, altitude, rock_type, min_grade, max_grade, exposure, photo_url, thumbnail_url) VALUES
('Viaduc des Fauvettes', 'Bures-sur-Yvette', '91440', 48.678913, 2.152492, 114, 'grès', '3c', '7c', 'protégé', NULL, NULL),
('Rocher du Corbeau', 'Rimbach-près-Masevaux', '68290', 47.795171, 6.992000, 1002, 'granite', '4a', '6c', 'exposé', NULL, NULL),
('Les Gaillands', 'Chamonix-Mont-Blanc', '74400', 45.915253, 6.846298, 1037, 'gneiss', '2c', '7a', 'variable', NULL, NULL),
('Roche Corbière', 'Saint-Étienne', '42000', 45.395586, 4.449295, 753, 'granit', '3a', '8a', 'exposé', NULL, NULL),
('Coupeau', 'Les Houches', '74310', 45.904710, 6.791486, 1299, 'gneiss', '4c', '7a', 'protégé', NULL, NULL),
('La Garotte', 'Baudéan', '65710', 43.018574, 0.155347, 735, 'calcaire', '3a', '7a', 'exposé', NULL, NULL),
('Les Abeilles', 'Opoul-Périllos', '66600', 42.870453, 2.850896, 283, 'calcaire', '4b', '7a', 'exposé', NULL, NULL),
('Tour Carrée', 'Saffres', '21350', 47.371954, 4.581260, 482, 'calcaire', '3b', '8a', 'protégé', NULL, NULL),
('Les Chavants', 'Les Houches', '74310', 45.897351, 6.782103, 1018, 'gneiss', '4b', '5b', 'protégé', NULL, NULL),
('La Rosière', 'La Balme-de-Thuy', '74230', 45.918765, 6.297025, 874, 'calcaire', '5a', '6a', 'exposé', NULL, NULL),
('Le Virage', 'Marseille (Calanques)', '13009', 43.217732, 5.451654, 262, 'calcaire', '5c', '8a', 'exposé', NULL, NULL),
('Malsaire', 'Mont-Saxonnex', '74130', 46.052153, 6.462805, 950, 'calcaire', '3b', '8b', 'protégé', NULL, NULL),
('Le Cube', 'Plougastel-Daoulas', '29470', 48.380595, -4.393371, 86, 'grès', '3a', '7a', 'protégé', NULL, NULL),
('Remigny', 'Remigny', '71150', 46.904538, 4.732228, 256, 'calcaire', '4b', '8a', 'protégé', NULL, NULL),
('Col de la Madeleine', 'Val-Cenis', '73500', 45.300884, 6.948472, 1750, 'schiste', '4b', '6c', 'partiellement protégé', NULL, NULL),
('Alpinodrome', 'Marseille', '13008', 43.217807, 5.357819, 62, 'calcaire', '4c', '7b', 'exposé', NULL, NULL),
('La Duchère', 'Les Contamines-Montjoie', '74170', 45.796467, 6.724391, 1310, 'gneiss', '3b', '7c', 'exposé', NULL, NULL),
('Seynes', 'Seynes', '30580', 44.118252, 4.253755, 309, 'calcaire', '4a', '9a', 'exposé', NULL, NULL),
('Blocs de Médonnet', 'Sallanches', '74700', 45.914598, 6.632844, 750, 'granit', '6c', '7a', 'exposé', NULL, NULL),
('Anthon', 'Mieussy', '74440', 46.136989, 6.502062, 713, 'calcaire', '4a', '8c', 'exposé', NULL, NULL),
('Désert de l’Écureuil', 'Seyssinet-Pariset', '38170', 45.176943, 5.677782, 441, 'calcaire', '5a', '8a', 'protégé', NULL, NULL),
('Chaos de Targasonne', 'Targasonne', '66120', 42.494368, 1.973695, 1546, 'granite', '3a', '8b', 'protégé', NULL, NULL),
('Valflaunès', 'Valflaunès', '34270', 43.819461, 3.859136, 286, 'calcaire', '4a', '6b', 'exposé', NULL, NULL),
('Rocher de la Reine', 'Arbonne-la-Forêt', '77630', 48.392131, 2.560895, 110, 'grès', '3a', '8a', 'protégé', NULL, NULL),
('Roche d''Olima', 'Épinal', '88000', 48.160980, 6.404560, 381, 'grès', '5a', '7a', 'protégé', NULL, NULL),
('Le Heidenkopf', 'Niederbronn-les-Bains', '67110', 48.965589, 7.644765, 411, 'grès', '4b', '8b', 'exposé', NULL, NULL),
('Cuisinière Carnage', 'Fontainebleau', '77300', 48.409127, 2.616969, 105, 'grès', '6a', '8a', 'exposé', NULL, NULL),
('Rocher des Souris', 'Noisy-sur-École', '77123', 48.385749, 2.523100, 93, 'grès', '3a', '7c', 'protégé', NULL, NULL),
('Diplodocus', 'Noisy-sur-École', '77123', 48.371496, 2.532300, 77, 'grès', '4a', '6b', 'protégé', NULL, NULL),
('Les Ayes (La Grave)', 'La Grave', '05320', 45.051533, 6.280246, 1848, 'granite', '3b', '7a', 'exposé', NULL, NULL);

INSERT INTO crag_seasons (crag_id, favorable_seasons) VALUES
(1, 'ETE'),
(2, 'PRINTEMPS'),
(3, 'PRINTEMPS'), (3, 'ETE'), (3, 'AUTOMNE'),
(4, 'PRINTEMPS'), (4, 'ETE'), (4, 'AUTOMNE'), (4, 'HIVER'),
(5, 'ETE'),
(6, 'PRINTEMPS'),
(7, 'PRINTEMPS'), (7, 'ETE'), (7, 'AUTOMNE'), (7, 'HIVER'),
(8, 'PRINTEMPS'), (8, 'AUTOMNE'),
(9, 'PRINTEMPS'), (9, 'AUTOMNE'),
(10, 'PRINTEMPS'), (10, 'ETE'), (10, 'AUTOMNE'),
(11, 'PRINTEMPS'), (11, 'ETE'), (11, 'AUTOMNE'), (11, 'HIVER'),
(12, 'PRINTEMPS'), (12, 'ETE'), (12, 'AUTOMNE'), (12, 'HIVER'),
(13, 'PRINTEMPS'), (13, 'AUTOMNE'), (13, 'HIVER'),
(14, 'PRINTEMPS'), (14, 'ETE'), (14, 'AUTOMNE'),
(15, 'ETE'), (15, 'AUTOMNE'),
(16, 'PRINTEMPS'), (16, 'ETE'), (16, 'AUTOMNE'), (16, 'HIVER'),
(17, 'PRINTEMPS'), (17, 'ETE'), (17, 'AUTOMNE'),
(18, 'PRINTEMPS'), (18, 'AUTOMNE'),
(19, 'PRINTEMPS'), (19, 'ETE'), (19, 'AUTOMNE'),
(20, 'PRINTEMPS'), (20, 'ETE'), (20, 'AUTOMNE'),
(21, 'PRINTEMPS'), (21, 'AUTOMNE'), (21, 'HIVER'),
(22, 'PRINTEMPS'), (22, 'AUTOMNE'), (22, 'HIVER'),
(23, 'PRINTEMPS'), (23, 'AUTOMNE'), (23, 'HIVER'),
(24, 'ETE'), (24, 'AUTOMNE'),
(25, 'PRINTEMPS'), (25, 'ETE'),
(26, 'PRINTEMPS'), (26, 'ETE'), (26, 'AUTOMNE'),
(27, 'PRINTEMPS'), (27, 'ETE'), (27, 'AUTOMNE'), (27, 'HIVER'),
(28, 'PRINTEMPS'), (28, 'ETE'),
(29, 'PRINTEMPS'), (29, 'AUTOMNE'),
(30, 'ETE');

INSERT INTO crag_orientations (crag_id, orientations) VALUES
(1, 'TOUTES'),
(2, 'SUD'),
(3, 'SUD'), (3, 'OUEST'),
(4, 'NORD'), (4, 'EST'), (4, 'SUD'), (4, 'OUEST'),
(5, 'SUD'),
(6, 'SUD'),
(7, 'SUD_EST'),
(8, 'OUEST'), (8, 'SUD_OUEST'),
(9, 'OUEST'),
(10, 'SUD_EST'),
(11, 'SUD'), (11, 'SUD_EST'),
(12, 'SUD'), (12, 'SUD_EST'), (12, 'SUD_OUEST'),
(13, 'NORD'),
(14, 'NORD'),
(15, 'NORD'),
(16, 'NORD'), (16, 'EST'),
(17, 'OUEST'), (17, 'NORD_OUEST'),
(18, 'SUD_OUEST'),
(19, 'TOUTES'),
(20, 'SUD'),
(21, 'SUD'),
(22, 'NORD'), (22, 'EST'), (22, 'SUD'),
(23, 'SUD'),
(24, 'NORD'), (24, 'EST'), (24, 'SUD'),
(25, 'SUD'),
(26, 'OUEST'),
(27, 'NORD'), (27, 'EST'), (27, 'SUD'),
(28, 'NORD'), (28, 'EST'), (28, 'SUD'),
(29, 'NORD'), (29, 'EST'), (29, 'SUD'),
(30, 'SUD');

-- ADMIN + 10 USERS --
INSERT INTO user (id, email, password, username, role) VALUES
(1, 'climbjam@example.com', '$2a$12$R.QBr1uwWlhNU1LpSL7c3OBSPJw95gL/eAuZGTsTMoCCherO0WC5y', 'ClimbJAM', 'ADMIN'),
(2, 'alice@example.com', '$2a$12$R.QBr1uwWlhNU1LpSL7c3OBSPJw95gL/eAuZGTsTMoCCherO0WC5y', 'alice', 'USER'),
(3, 'ben@example.com', '$2a$12$R.QBr1uwWlhNU1LpSL7c3OBSPJw95gL/eAuZGTsTMoCCherO0WC5y', 'ben', 'USER'),
(4, 'chloe@example.com', '$2a$12$R.QBr1uwWlhNU1LpSL7c3OBSPJw95gL/eAuZGTsTMoCCherO0WC5y', 'chloe', 'USER'),
(5, 'daniel@example.com', '$2a$12$R.QBr1uwWlhNU1LpSL7c3OBSPJw95gL/eAuZGTsTMoCCherO0WC5y', 'daniel', 'USER'),
(6, 'emma@example.com', '$2a$12$R.QBr1uwWlhNU1LpSL7c3OBSPJw95gL/eAuZGTsTMoCCherO0WC5y', 'emma', 'USER'),
(7, 'frank@example.com', '$2a$12$R.QBr1uwWlhNU1LpSL7c3OBSPJw95gL/eAuZGTsTMoCCherO0WC5y', 'frank', 'USER'),
(8, 'grace@example.com', '$2a$12$R.QBr1uwWlhNU1LpSL7c3OBSPJw95gL/eAuZGTsTMoCCherO0WC5y', 'grace', 'USER'),
(9, 'henri@example.com', '$2a$12$R.QBr1uwWlhNU1LpSL7c3OBSPJw95gL/eAuZGTsTMoCCherO0WC5y', 'henri', 'USER'),
(10, 'oriane@example.com', '$2a$12$R.QBr1uwWlhNU1LpSL7c3OBSPJw95gL/eAuZGTsTMoCCherO0WC5y', 'oriane', 'USER'),
(11, 'tristan@example.com', '$2a$12$R.QBr1uwWlhNU1LpSL7c3OBSPJw95gL/eAuZGTsTMoCCherO0WC5y', 'tristan', 'USER');

-- PROFILES --
INSERT INTO profile (user_id, avatar_url, city, postal_code) VALUES
(1, NULL, 'Tours', '37000'),
(2, NULL, 'Lille', '59000'),
(3, NULL, 'Lyon', '69001'),
(4, NULL, 'Marseille', '13001'),
(5, NULL, 'Montpellier', '34000'),
(6, NULL, 'Bordeaux', '33000'),
(7, NULL, 'Nice', '06000'),
(8, NULL, 'Nantes', '44000'),
(9, NULL, 'Strasbourg', '67000'),
(10, NULL, 'Toulouse', '31000'),
(11, NULL, 'Grenoble', '38000');

-- ROUTES --
INSERT INTO route (id, crag_id, name, grade, height, incline_type, anchor_type, bolt_type, bolt_count, sector) VALUES
(1, 1, 'Abrasive Stone', '7a', 35, 'dalle positive', '2 points chaînés', 'broches', NULL, 'Pilier 4'),
(2, 1, 'Desmaison', '6c', 30, NULL, '2 points chaînés', 'broches', NULL, 'Pilier 8'),
(3, 3, 'Le Dièdre des Gaillands', '5c', 28, 'dièdre', '2 points chaînés', 'plaquettes', 8, 'Secteur Central'),
(4, 3, 'Les Dalles Grises', '6a', 22, 'dalle', '2 points chaînés', 'plaquettes', 7, 'Secteur Gauche'),
(5, 11, 'Virage à Droite', '7a+', 18, 'surplomb', '2 points chaînés', 'plaquettes', 9, 'Mur Principal'),
(6, 11, 'Le Crux du Virage', '7b', 20, 'surplomb', '2 points chaînés', 'plaquettes', 10, 'Mur Principal'),
(7, 6, 'Calcaire en Fête', '6b', 25, 'mur raide', '2 points chaînés', 'plaquettes', 8, 'Secteur Gauche');

-- CLIMBING TYPES --
INSERT INTO route_climbing_types (route_id, climbing_types) VALUES
(1, 'VOIE'),
(2, 'GRANDE_VOIE'),
(3, 'VOIE'),
(4, 'VOIE'),
(5, 'VOIE'),
(6, 'VOIE'),
(7, 'VOIE');

-- SESSIONS --
INSERT INTO session (id, user_id, crag_id, date) VALUES
(1, 2, 1,  '2025-04-12'), -- Alice au Viaduc des Fauvettes
(2, 3, 3,  '2025-05-03'), -- Ben aux Gaillands
(3, 4, 11, '2025-06-15'), -- Chloé au Virage
(4, 5, 6,  '2025-07-02'); -- Daniel à La Garotte

-- ASCENTS --
-- Alice (user_id=2)
INSERT INTO ascent (user_id, route_id, session_id, date, style, tries, comment) VALUES
(2, 1, 1, '2025-04-12', 'A_VUE', 1, 'Belle dalle technique, bon feeling'),
(2, 2, 1, '2025-04-12', 'ECHEC', 2, 'Tombée au dernier mouv, à retravailler');

-- Ben (user_id=3)
INSERT INTO ascent (user_id, route_id, session_id, date, style, tries, comment) VALUES
(3, 3, 2, '2025-05-03', 'FLASH', 1, 'Parfait pour s’échauffer'),
(3, 4, 2, '2025-05-03', 'REDPOINT', 3, 'Dur au départ mais passé après travail');

-- Chloé (user_id=4)
INSERT INTO ascent (user_id, route_id, session_id, date, style, tries, comment) VALUES
(4, 5, 3, '2025-06-15', 'TRAVAIL', 4, 'Magnifique surplomb, pas encore enchaîné'),
(4, 6, 3, '2025-06-15', 'ECHEC', 2, 'Très physique, encore hors de portée');

-- Daniel (user_id=5)
INSERT INTO ascent (user_id, route_id, session_id, date, style, tries, comment) VALUES
(5, 7, 4, '2025-07-02', 'A_VUE', 1, 'Bonne fluidité, belles prises'),
(5, 3, 4, '2025-07-02', 'REDPOINT', 2, 'Un peu dur au crux mais réussi'),
(5, 4, 4, '2025-07-02', 'FLASH', 1, 'Facile grâce à une bonne lecture');