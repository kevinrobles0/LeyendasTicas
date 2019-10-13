-- phpMyAdmin SQL Dump
-- version 4.0.10.14
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Apr 15, 2017 at 10:36 PM
-- Server version: 5.6.33-cll-lve
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `AppLectuTicas`
--
CREATE DATABASE IF NOT EXISTS `AppLectuTicas` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `AppLectuTicas`;

DELIMITER ;
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `sp_getQuestionAnswers`;
CREATE DEFINER=`cpses_adwCqcfD2G`@`localhost` PROCEDURE `sp_getQuestionAnswers`(IN `pQuestionId` INT)
    READS SQL DATA
    SQL SECURITY INVOKER
    COMMENT 'Gets the answers for a story''s question with random sort.'
SELECT a.Id, a.Text, qa.CorrectAnswer
FROM answers a
	INNER JOIN questions_answers qa
		ON a.Id = qa.Answer_Id
WHERE qa.Question_Id = pQuestionId
ORDER BY RAND();

DROP PROCEDURE IF EXISTS `sp_getStories`;
CREATE DEFINER=`cpses_adwCqcfD2G`@`localhost` PROCEDURE `sp_getStories`()
    READS SQL DATA
    SQL SECURITY INVOKER
    COMMENT 'Get a list of stored stories.'
SELECT Id, Name
FROM stories;

DROP PROCEDURE IF EXISTS `sp_getStoryParagraphs`;
CREATE DEFINER=`cpses_adwCqcfD2G`@`localhost` PROCEDURE `sp_getStoryParagraphs`(IN `pStoryId` INT)
    READS SQL DATA
    SQL SECURITY INVOKER
    COMMENT 'Gets the paragraphs of a given story.'
SELECT sp.ParagraphNumber, p.Text
FROM paragraphs p
	INNER JOIN stories_paragraphs sp
		ON p.Id = sp.Paragraph_Id
WHERE sp.Story_Id = pStoryId
ORDER BY sp.ParagraphNumber ASC;

DROP PROCEDURE IF EXISTS `sp_getStoryQuestions`;
CREATE DEFINER=`cpses_adwCqcfD2G`@`localhost` PROCEDURE `sp_getStoryQuestions`(IN `pStoryId` INT)
    READS SQL DATA
    SQL SECURITY INVOKER
    COMMENT 'Get questions related to a given story with random sorting.'
SELECT q.Id, q.Text
FROM questions q
	INNER JOIN stories_questions sq
		ON q.ID = sq.Question_Id
WHERE sq.Story_Id = pStoryId
ORDER BY RAND();

-- --------------------------------------------------------

--
-- Table structure for table `answers`
--

DROP TABLE IF EXISTS `answers`;
CREATE TABLE IF NOT EXISTS `answers` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Text` varchar(200) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`Id`),
  FULLTEXT KEY `Text` (`Text`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci COMMENT='Register of exercises'' answers' AUTO_INCREMENT=49 ;

--
-- Dumping data for table `answers`
--

INSERT INTO `answers` (`Id`, `Text`) VALUES
(1, 'Estaba haciendo una imitación de un animal salvaje.'),
(2, 'Estaba haciendo una fiesta sorpresa.'),
(3, 'Llegó tarde y ebrio.'),
(4, 'En la mañana.'),
(5, 'En la noche.'),
(6, 'Al amanecer.'),
(7, 'Como un perro negro que aparece y desaparece por obra de magia.'),
(8, 'Como un fantasma que puede despegar su cabeza.'),
(9, 'Como un niño cubierto por una capa oscura.'),
(10, 'San Juan del Murciélago.'),
(11, 'La Uruca.'),
(12, 'Los Yoses.'),
(13, 'Hizo enfurecer a una bruja.'),
(14, 'Aceptó un trato con el diablo.'),
(15, 'Su padre le puso una maldición por asustarlo.'),
(16, 'No atacó a nadie.'),
(17, 'Atacó a los hombres del pueblo donde vive su padre.'),
(18, 'Atacó a todo animal que se le acercaba.'),
(19, 'Acompañaba a los solitarios y los protegía.'),
(20, 'Entraba a las casas por la noche y destruía las ventanas.'),
(21, 'Se comía a las gallinas de las fincas.'),
(22, 'Sufre de un ataque al corazón y muere.'),
(23, 'Esa persona enloquece.'),
(24, 'El Cadejos se vuelve más grande y enfurece.'),
(25, 'Porque un caballo se asustó por un relámpago.'),
(26, 'Alguien se encontró con la Cegua.'),
(27, 'Confundieron el sonido de las ramas de los árboles.'),
(28, 'Se vuelven alérgicas a los caballos.'),
(29, 'Terminan a la deriva del mar.'),
(30, 'Algunos mueren del susto y otros sufren enfermedades.'),
(31, 'Jinetes que cabalgan en caravanas.'),
(32, 'Jinetes de las reservas indígenas.'),
(33, 'Jinetes que cabalgan solos.'),
(34, 'Les pide que la lleven al pueblo para ver a su madre.'),
(35, 'Los detiene para cobrarles un peaje de paso.'),
(36, 'Aparece como una vendedora ambulante.'),
(37, 'Como una joven muy linda, blanca, ojos negros y pelo rizado.'),
(38, 'Como una señora de cabello castaño, ojos verdes y pelo lacio.'),
(39, 'Como una niña joven de piel morena y cabello trenzado.'),
(40, 'Le clava sus uñas en la cabeza.'),
(41, 'Hace que los jinetes vuelvan a verla y su rostro cambia.'),
(42, 'Grita de forma tenebrosa.'),
(43, 'Aparecen dos cuernos en su frente y se convierte en un monstruo gigante.'),
(44, 'Su cabello crece por varios metros y su piel se torna pálida.'),
(45, 'Su cara toma la forma de calavera de caballo, con ojos que lanzan fuego y dientes muy grandes.'),
(46, 'Mueren los niños y enferman los ancianos.'),
(47, 'Mueren los hombres con malas intenciones y los otros quedan enfermos.'),
(48, 'Todos mueren, nadie queda enfermo.');

-- --------------------------------------------------------

--
-- Table structure for table `paragraphs`
--

DROP TABLE IF EXISTS `paragraphs`;
CREATE TABLE IF NOT EXISTS `paragraphs` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Text` varchar(1000) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`Id`),
  FULLTEXT KEY `Text` (`Text`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COMMENT='Register of Stories'' Paragraphs' AUTO_INCREMENT=31 ;

--
-- Dumping data for table `paragraphs`
--

INSERT INTO `paragraphs` (`Id`, `Text`) VALUES
(1, 'Vení temprano le decía Juan a su padre que por sus largas borracheras no paraba en su casa ni de día, ni de noche. A lo cual contestaba este “hijo de Dios en mi casa cuídame tu a mi familia, madre que te engendró y padre respeto por Dios quiero yo”.\n\nAburrido de estas palabras que a diario escuchaba, decidió darle un escarmiento, consiguió un cuero negro, varias cadenas de perro y se escondió a su espera.'),
(2, 'Como siempre y de madrugada apareció su padre con tremenda borrachera, aprovechó Juan y poniéndose el cuero y sonando las cadenas quiso darle una lección.\n\n“Por asustarme y contradecirme “cadejos” quedarás y a todos los borrachos del mundo en sus necesidades ayudarás”.'),
(3, 'Espeluznante y fantástico animal que la gente supersticiosa lo señala como un enorme perro, de ojos encendidos, de pelo muy largo y enmarañado, que desde tempranas horas de la noche salía a asustar a las personas, en especial a los que andaban en malos pasos o niños desobedientes, o a espantar caballos, gallinas y hacer otras diabluras más.'),
(4, 'Según algunos vecinos del pueblo, era lo más tétrico y pavoroso que le podía haber sucedido a los que hubieran tenido ia mala suerte de ver a la más terrible de todas esas maléficas criaturas: el “Cadejos”. Al perro negro y encantado que aparecía y desaparecía como obra de magia, arrastrando enormes e invisibles cadena? que se oían pero que no se veían, rechinando largos y puntiagudos colmillos y lanzando fuego por la boca, ojos y orejas. Las personas que tuvieron la mala suerte de verlo solían decir que era el verdadero Lucifer personificado en forma de perro.'),
(5, 'Se cuenta también de que muchos hombres y muy valientes que se aventuraron a andar a deshoras de la noche, por las calles solitarias de San Juan del Murciélago de antaño, en más de una ocasión regresaron a sus casas “jadeando” de la carrera que les pegó el “espanto del Cadejos”, con la vista casi torcida al revés, y además, todos “mojados” y “untados” por haber visto al maléfico perro negro.\\n\\nSegún los relatos que dan consistencia a la leyenda del Cadejos, este horrible perro negro es el resultado de una maldición. Transportándonos al pasado, veamos qué fue lo que sucedió:'),
(6, 'Era una humilde familia; el marido solía con frecuencia emborracharse en las cantinas y, llegando a deshoras de la noche a su casa, hacía un escándalo tremendo. Sacaba la cruceta y amenazaba de muerte a todo aquel que se atreviera a ponerle la mano encima. Otras veces le pegaba salvajemente a su mujer por motivos realmente insignificantes. El hijo mayor de la familia decidió un día darle un buen susto cuando éste regresaba de sus andanzas nocturnas.'),
(7, 'Se consiguió un cuero peludo y, cuando fue ya tarde de la noche, se dirigió hacia un punto oscuro y solitario del camino, por el cual tenía que pasar su padre de regreso a casa.\n\nY de veras, cuando distinguió la sombra del hombre que se acercaba, se puso el cuero peludo, luego avanzó de cuatro patas al encuentro de su padre, convertido en horrendo animal de ultratumba.'),
(8, 'El resultado fue óptimo para el muchacho, pues su papá, al ver aquella aterradora aparición, casi le da un ataque del susto y corrió tan rápido alejándose de aquel lugar que parecía que los tantos años vividos ya no le pesaran.\\n\\nLa estremecedora aparición continuó sal iéndole al encuentro en el mismo paraje, cada vez que su papá regresaba de sus correrías nocturnas. Pero, a pesar de todos estos sustos, no lo hacía abandonar su mala conducta y mucho menos el vicio del licor.'),
(9, 'Un buen día se le agotó la paciencia al hombre y dominado el miedo que aquella espeluznante aparición le producía, levantó la cruceta para disponerse a hacer un picadillo a cuchilladas al espanto, pero cuando ya iba a asestar el primer golpe mortal, escuchó !a voz de su hijo que muy temeroso le gritaba que todo había sido una broma, que lo perdonara y que no lo matara.'),
(10, 'El padre, al constatar que aquel hijo lo había hecho objeto de burla y de tan horrenda broma, profirió una maldición al muchacho: “De cuatro patas andarás toda la vida”. La maldición se cumplió y aquel hijo se convirtió en perro grande y negro, que la noche más oscura no lo es tanto con su negrura.'),
(11, 'Esa fue la maldición por haber asustado a su padre: pasaría él a ser el Cadejos, para horror de la gente: ese perro de apariencia pavorosa, capaz de erizarle el pelo al más pintado.'),
(12, 'Nunca se ha sabido que este espanto haya atacado a nadie. Al contrario, muchos supersticiosos aseguran que más bien suele acompañar a los solitarios caminantes para defenderlos del peligro. Aunque la tradición advierte, sin embargo , que si alguien intenta golpear a este perro en tinieblas, éste aumentará de tamaño, ligero se enfurecerá y el atrevido corre seno peligro de una agresión.'),
(13, '¿Será cierto o no la anterior versión?\n\nLe será fácil a aquel que quisiera averiguarlo. Todo es encontrarse con el Cadejos, en las calles oscuras de San Juan del Murciélago.'),
(14, 'Me acompañaba un hombre del campo, alma ingenua y sana que había logrado conservar, con toda su pureza, su nativa sencillez. Yo, que amo esas almas vírgenes de artificio, y me complazco en penetrar en ellas, escuchaba atento su conversación, y sólo de cuando en cuando le interrumpía para hacerle una pregunta que era algo como un buceo. Ni un aleteo de viento movía los árboles; nadie transitaba por el camino y remaba un silencio majestuoso en la plenitud de la noche soberbiamente constelada.'),
(15, 'Apenas si venía a turbar esa calma solemne, como un crujir de raso, el murmureo apagado de un riachuelo linfático que discurría, lamiendo las piedras, en el fondo de un próximo barranco. De pronto oírnos el golpe acompasado de un caballo que trota, bien opacado el golpear de sus cascos por el piso de tierra.'),
(16, '– “Alguien viene”, dije a mi compañero.\\n\\nPuso alerta el experto oído de hombre de campo y, con la seguridad del que está convencido de lo que afirma, contestó:\n– “No viene por este camino, va por el otro de más arriba.”– No había acabado de pronunciar esta frase cuando se apagó el ruido de las pisadas, como si el jinete se hubiera detenido de pronto. Unos momentos después debió seguir la marcha, pero en lugar de rítmico golpear del trote se dejó oír el repiquetear desatentado de un galope tendido.'),
(17, 'Con voz ahuecada que parecía envolver un supersticioso respeto, el campesino murmuró:\n\n– “Ese caminante se ha encontrado con la Cegua. Pero no tenga miedo, patrón, a nosotros no nos sale: somos dos, y para ajuste caminamos a pie”.\n- “¿La Cegua?” – prorrumpí con extrañeza. – “¿Qué animal es ese?”\n\nMe pareció que una sonrisa había retozado en los labios de aquel buen hombre que repuso, como si no se animara a creer en mi ignorancia:\n\n– “¡Pero, señor! ¿Cómo es posible que Ud., que lee tanto, no sepa qué es la Cegua? Es el mismísimo demonio, y Dios lo guarde de encontrarse con ella”. “Te aseguro que no lo sé; explícamelo”.'),
(18, 'Estábamos ya muy cerca de la estancia y seguía oyéndose la vertiginosa carrera del caballo. Los perros que nos habían olfateado ladraban, no en son de alarma sino de gusto. La noche era fresca, las estrellas regaban siempre su oro pálido sobre el vasto paisaje, y el riachuelo linfático proseguía en su crujir de raso. El ambiente todo parecía convidar a los consejos y relatos misteriosos. Comenzamos a caminar más despacio, y el rústico, con un sabor de poesía que sólo es propio de la credulidad de las imaginaciones en bruto, se expresó asi:'),
(19, 'No hay uno solo de los que han visto a la Cegua que se haya quedado como era antes. Hombres fuertes, sanos, colorados, que nunca se afligieron por el trabajo, después que se les apareció resultaron amarillos y flacos y flojos. Algunos también se murieron de puro susto – y citó a varios de los que habían perdido la vida a causa de la terrible aparición.'),
(20, '– “No es fácil verla” – prosiguió diciendo – “en todas partes; son ciertos lugares los que le cuadran. Por aquí anda siempre y por eso, fíjese que es raro ver un caminante a caballo solo. Casi siempre van dos juntos”.\n\n– “¿No es posible que la vean dos?” – le interrumpí.\n\n– “Cuando va uno sólito es que se asoma,” repuso hilvanando de nuevo su relato, con la satisfacción del que sabe que es escuchado con vivo interés.\n\n'),
(21, '– “En algún sitio lejos del poblado, sobre todo si hay arboleda y el camino es estrecho, es donde le gusta sorprender a los viajeros.” En medio del camino se presenta y, con una voz muy dulce y muy débil, como si se estuviera muriendo, dice:\n\n– “Señor, estoy muy cansada, y tengo que ir a ver a mi madre que está enferma, me quiere llevar al pueblo de …?”, y dice el nombre del pueblo que está más cerca porque, como es el mismo enemigo, todo lo sabe.'),
(22, '– “¿Entonces es una persona, o tiene el aspecto de persona?” – me atreví a interrumpirle nuevamente.\n\n– “Es una joven muy linda, blanca, con los ojos negros y grandes, el pelo rizado y la boca preciosa. Todos los que la miran así se encantan de ella y, sobre todo, les da lástima porque se le ve cansancio en la cara y se le siente en la voz”.\n\nUn céfiro fino comenzó a juguetear en aquel momento, estremeciéndose las hojas con un temblor suave, como si un ser misterioso e invisible se adelantara, abriéndose paso entre las ramas tupidas. La naturaleza ayudaba al narrador.'),
(23, '– “Ni los más cerrados se resisten a su ruego, y todos caen en su lazo. Hay quienes le ofrecen la delantera de la montura y otros que prefieren llevarla a la grupa. Para ella es lo mismo. Cuando comienza a caminar, si va adelante vuelve la cara, si va atrás hace que el jinete la vuelva. Aquí lo espantoso. Aquella mujer hermosa ya no es ella. Tiene la cara corno la calavera de un caballo: los ojos lanzan fuego, enseña con amenaza los dientes pelados y muy grandes, tiene la boca abierta y arroja un vaho por aliento que huele a podrido. Al mismo tiempo sus brazos, como fierro, se agarran del jinete. El mismo caballo, que parece que se da cuenta de lo que lleva encima, arranca a correr como loco sin que ninguno lo pueda contener”.'),
(24, '– “¿Y qué pasa después?”\n\n– “Los que al hacer montar a la joven hermosa han tenido malas intenciones, esos mueren todos, y se les encuentra tendidos con los ojos abiertos y saltados. Los otros, ya se lo dije, para el resto de su vida quedan sin servir para nada”.'),
(25, 'Llegamos al portón de la estancia y los perros ladraban más fuerte. Yo, entre tanto, me internaba en una profunda meditación, ¿No tiene una enseñanza muy saludable esta fantasía? ¿Quién en el camino de la vida no se ha encontrado a la Cegua? ¿Quién no ha sentido la seducción de la belleza con todos sus hechizos físicos, y nada más? ¿Quién no se ha rendido a la piedad mal entendida? ¿Quién en un momento no ha tomado el abono por las hojas? Y después… la debilidad en el cuerpo o en el alma, la muerte acaso.'),
(26, 'La Cegua, grande o pequeña, con huellas de arañazo o surco de arado, ¡todos la hemos encontrado en nuestro camino!.');

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
CREATE TABLE IF NOT EXISTS `questions` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Text` varchar(200) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`Id`),
  FULLTEXT KEY `Text` (`Text`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COMMENT='Register of questions for story exercises' AUTO_INCREMENT=17 ;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`Id`, `Text`) VALUES
(1, '¿Por qué Juan quiso asustar a su padre?'),
(2, '¿Cuando aparece el Cadejos para asustar a la gente?'),
(3, '¿Cómo describen los vecinos del pueblo al Cadejos?'),
(4, '¿Cómo se llama el lugar dónde suele aparecer el Cadejos?'),
(5, '¿Por qué el hijo del padre ebrio se convirtió en el Cadejos?'),
(6, '¿A cuántas personas atacó el Cadejos?'),
(7, 'Si el Cadejos no atacaba a las personas, ¿Qué hacia?'),
(8, '¿Qué pasa si alguien trata de golpear al Cadejos?'),
(9, '¿Por qué los hombres del campo escuchan un galope repentino?'),
(10, '¿Qué pasa con los hombres que se encuentran con la Cegua?'),
(11, '¿Qué clase de jinete de caballo es la que ataca la Cegua?'),
(12, '¿Cómo es que la Cegua atrae a sus víctimas?'),
(13, '¿Cómo suele aparecer la Cegua ante sus víctimas?'),
(14, '¿Qué pasa cuando la Cegua decide atacar a sus víctimas?'),
(15, '¿Cuál es la apariencia de la Cegua cuando ataca a sus víctimas?'),
(16, '¿A quienes mata la Cegua y quienes quedan enfermos por ella?');

-- --------------------------------------------------------

--
-- Table structure for table `questions_answers`
--

DROP TABLE IF EXISTS `questions_answers`;
CREATE TABLE IF NOT EXISTS `questions_answers` (
  `Question_Id` int(10) unsigned NOT NULL,
  `Answer_Id` int(10) unsigned NOT NULL,
  `CorrectAnswer` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`Question_Id`,`Answer_Id`),
  KEY `FK_QA_Answers` (`Answer_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Links questions to answers and sets the correct answer for given questions';

--
-- Dumping data for table `questions_answers`
--

INSERT INTO `questions_answers` (`Question_Id`, `Answer_Id`, `CorrectAnswer`) VALUES
(1, 1, b'0'),
(1, 2, b'0'),
(1, 3, b'1'),
(2, 4, b'0'),
(2, 5, b'1'),
(2, 6, b'0'),
(3, 7, b'1'),
(3, 8, b'0'),
(3, 9, b'0'),
(4, 10, b'1'),
(4, 11, b'0'),
(4, 12, b'0'),
(5, 13, b'0'),
(5, 14, b'0'),
(5, 15, b'1'),
(6, 16, b'1'),
(6, 17, b'0'),
(6, 18, b'0'),
(7, 19, b'1'),
(7, 20, b'0'),
(7, 21, b'0'),
(8, 22, b'0'),
(8, 23, b'0'),
(8, 24, b'1'),
(9, 25, b'0'),
(9, 26, b'1'),
(9, 27, b'0'),
(10, 28, b'0'),
(10, 29, b'0'),
(10, 30, b'1'),
(11, 31, b'0'),
(11, 32, b'0'),
(11, 33, b'1'),
(12, 34, b'1'),
(12, 35, b'0'),
(12, 36, b'0'),
(13, 37, b'1'),
(13, 38, b'0'),
(13, 39, b'0'),
(14, 40, b'0'),
(14, 41, b'1'),
(14, 42, b'0'),
(15, 43, b'0'),
(15, 44, b'0'),
(15, 45, b'1'),
(16, 46, b'0'),
(16, 47, b'1'),
(16, 48, b'0');

-- --------------------------------------------------------

--
-- Table structure for table `stories`
--

DROP TABLE IF EXISTS `stories`;
CREATE TABLE IF NOT EXISTS `stories` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`Id`),
  FULLTEXT KEY `Name` (`Name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci COMMENT='Register of Stories' AUTO_INCREMENT=3 ;

--
-- Dumping data for table `stories`
--

INSERT INTO `stories` (`Id`, `Name`) VALUES
(1, 'El Cadejos'),
(2, 'La Cegua');

-- --------------------------------------------------------

--
-- Table structure for table `stories_paragraphs`
--

DROP TABLE IF EXISTS `stories_paragraphs`;
CREATE TABLE IF NOT EXISTS `stories_paragraphs` (
  `Story_Id` int(10) unsigned NOT NULL,
  `Paragraph_Id` int(10) unsigned NOT NULL,
  `ParagraphNumber` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Story_Id`,`Paragraph_Id`),
  UNIQUE KEY `UN_Stories_ParagraphNumbers` (`Story_Id`,`ParagraphNumber`),
  KEY `FK_SP_Paragraphs` (`Paragraph_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci COMMENT='Links stories'' paragraphs and sets their order';

--
-- Dumping data for table `stories_paragraphs`
--

INSERT INTO `stories_paragraphs` (`Story_Id`, `Paragraph_Id`, `ParagraphNumber`) VALUES
(1, 1, 1),
(1, 2, 2),
(1, 3, 3),
(1, 4, 4),
(1, 5, 5),
(1, 6, 6),
(1, 7, 7),
(1, 8, 8),
(1, 9, 9),
(1, 10, 10),
(1, 11, 11),
(1, 12, 12),
(1, 13, 13),
(2, 14, 1),
(2, 15, 2),
(2, 16, 3),
(2, 17, 4),
(2, 18, 5),
(2, 19, 6),
(2, 20, 7),
(2, 21, 8),
(2, 22, 9),
(2, 23, 10),
(2, 24, 11),
(2, 25, 12),
(2, 26, 13);

-- --------------------------------------------------------

--
-- Table structure for table `stories_questions`
--

DROP TABLE IF EXISTS `stories_questions`;
CREATE TABLE IF NOT EXISTS `stories_questions` (
  `Story_Id` int(10) unsigned NOT NULL,
  `Question_Id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Story_Id`,`Question_Id`),
  KEY `FK_SQ_Questions` (`Question_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Links questions to stories';

--
-- Dumping data for table `stories_questions`
--

INSERT INTO `stories_questions` (`Story_Id`, `Question_Id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(2, 9),
(2, 10),
(2, 11),
(2, 12),
(2, 13),
(2, 14),
(2, 15),
(2, 16);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `questions_answers`
--
ALTER TABLE `questions_answers`
  ADD CONSTRAINT `FK_QA_Answers` FOREIGN KEY (`Answer_Id`) REFERENCES `answers` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_QA_Questions` FOREIGN KEY (`Question_Id`) REFERENCES `questions` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `stories_paragraphs`
--
ALTER TABLE `stories_paragraphs`
  ADD CONSTRAINT `FK_SP_Paragraphs` FOREIGN KEY (`Paragraph_Id`) REFERENCES `paragraphs` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_SP_Stories` FOREIGN KEY (`Story_Id`) REFERENCES `stories` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `stories_questions`
--
ALTER TABLE `stories_questions`
  ADD CONSTRAINT `FK_SQ_Questions` FOREIGN KEY (`Question_Id`) REFERENCES `questions` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_SQ_Stories` FOREIGN KEY (`Story_Id`) REFERENCES `stories` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;
