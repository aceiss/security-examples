CREATE DATABASE IF NOT EXISTS UserDB;
GRANT ALL PRIVILEGES ON UserDB.* TO 'UserDB'@'%';

USE UserDB;


SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


--
-- Table structure for table `Employees`
--

CREATE TABLE `Employees` (
  `username` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(20) NOT NULL DEFAULT '',
  `enabled` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES('pankaj', 'pankaj123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('aaron.edwards', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('adele.scargill', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('adriaan.wells', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('aife.ladner', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('alfred.vandermerwe', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('alicia.partridge', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('alicja.scott', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('amanda.jansone', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('anya.ault', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('austin.essof', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('ayse.james', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('bo.jain', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('caroline.bottcher', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('carolyn.raileanu', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('cecily.foote', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('cheryl.usher', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('chetan.whiteside', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('christine.morton', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('clarissa.womersley', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('clementine.jones', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('danny.aldridge', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('deana.vanne', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('demi.joy', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('diego.gaskin', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('douglas.lloyd', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('duane.thomason', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('farah.kerr', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('fergal.sallisgalvin', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('fidelma.saunders', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('francis.kennedy', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('gemma.rooney', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('georgios.green', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('geraldine.humphrey', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('gillian.pinkus', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('gisela.cox', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('hanna.bird', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('harrison.roberts', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('hope.burch', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('howard.burrett', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('isabel.tolcher', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('ivonnelaura.andrews', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('jacqueline.mcintosh', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('jayne.ratcliffe', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('joe.gordon', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('juliana.dingle', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('kasia.kowalski', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('kellyann.wolfswinkel', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('libby.sinclair', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('lisanne.cole', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('liva.deacon', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('lucie.dear', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('lydia.paolino', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('madison.stuttaford', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('marieclaire.hickman', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('martyn.bowen', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('mathew.ward', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('max.polmeer', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('michael.small', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('nicholas.lewens', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('olinda.stow', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('oluwasolape.whiteland', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('patrisha.kegg', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('pero.pym', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('peter.makin', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('rachael.brummitt', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('rachel.gillone', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('ramakanta.wynnesmythe', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('ravi.thorhauge', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('robyn.jenett', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('rosie.cutler', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('sarah.hawes', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('sebastian.cahilly', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('sharne.tremlett', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('sinclair.sherwood', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('somjeet.jeramsilvey', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('steven.sterry', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('stuart.vulinovic', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('tahsin.cartlidge', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('thijs.watkins', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('tuuli.peranic', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('velizar.melia', 'test123', 1);
INSERT INTO `Employees` (`username`, `password`, `enabled`) VALUES ('wendy.lax', 'test123', 1);



--
-- Table structure for table `Roles`
--

CREATE TABLE `Roles` (
  `username` varchar(20) NOT NULL DEFAULT '',
  `role` varchar(20) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO `Roles` (`username`, `role`) VALUES
('pankaj', 'Admin'),
('pankaj', 'CEO'),
('adele.scargill', 'Role B'),
('adele.scargill', 'Role C'),
('adriaan.wells', 'Role D'),
('aife.ladner', 'Role D'),
('alfred.vandermerwe', 'Role B'),
('alfred.vandermerwe', 'Role C'),
('alfred.vandermerwe', 'Role D'),
('alicia.partridge', 'Admin'),
('alicia.partridge', 'Role A'),
('alicia.partridge', 'Role D'),
('alicja.scott', 'Role B'),
('alicja.scott', 'Role C'),
('alicja.scott', 'Role D'),
('amanda.jansone', 'Admin'),
('amanda.jansone', 'Role D'),
('anya.ault', 'Role C'),
('austin.essof', 'Role A'),
('austin.essof', 'Role B'),
('austin.essof', 'Role C'),
('ayse.james', 'Role B'),
('ayse.james', 'Role D'),
('bo.jain', 'Role B'),
('bo.jain', 'Role D'),
('caroline.bottcher', 'Role C'),
('caroline.bottcher', 'Role D'),
('cecily.foote', 'Role C'),
('cheryl.usher', 'Admin'),
('chetan.whiteside', 'Role C'),
('chetan.whiteside', 'Role D'),
('christine.morton', 'Role B'),
('christine.morton', 'Role C'),
('clarissa.womersley', 'Role D'),
('clementine.jones', 'Role C'),
('deana.vanne', 'Role A'),
('deana.vanne', 'Role D'),
('demi.joy', 'Role C'),
('demi.joy', 'Role D'),
('diego.gaskin', 'Role C'),
('douglas.lloyd', 'Role C'),
('douglas.lloyd', 'Role D'),
('duane.thomason', 'Role C'),
('duane.thomason', 'Role D'),
('farah.kerr', 'Role B'),
('farah.kerr', 'Role C'),
('farah.kerr', 'Role D'),
('fergal.sallisgalvin', 'Role D'),
('fidelma.saunders', 'Role C'),
('francis.kennedy', 'Admin'),
('francis.kennedy', 'Role C'),
('francis.kennedy', 'Role D'),
('gemma.rooney', 'Role D'),
('georgios.green', 'Role A'),
('georgios.green', 'Role C'),
('georgios.green', 'Role D'),
('geraldine.humphrey', 'Role D'),
('gillian.pinkus', 'Role A'),
('gillian.pinkus', 'Role C'),
('gillian.pinkus', 'Role D'),
('gisela.cox', 'Role C'),
('gisela.cox', 'Role D'),
('hanna.bird', 'Role A'),
('hanna.bird', 'Role B'),
('harrison.roberts', 'Role A'),
('harrison.roberts', 'Role C'),
('harrison.roberts', 'Role D'),
('hope.burch', 'Role A'),
('hope.burch', 'Role B'),
('hope.burch', 'Role D'),
('howard.burrett', 'Role C'),
('howard.burrett', 'Role D'),
('isabel.tolcher', 'Role C'),
('isabel.tolcher', 'Role D'),
('ivonnelaura.andrews', 'Role D'),
('jacqueline.mcintosh', 'Role A'),
('jacqueline.mcintosh', 'Role B'),
('jayne.ratcliffe', 'Role A'),
('jayne.ratcliffe', 'Role B'),
('jayne.ratcliffe', 'Role D'),
('joe.gordon', 'Role A'),
('joe.gordon', 'Role B'),
('joe.gordon', 'Role D'),
('juliana.dingle', 'Role B'),
('kasia.kowalski', 'Role A'),
('kasia.kowalski', 'Role B'),
('kasia.kowalski', 'Role C'),
('kasia.kowalski', 'Role D'),
('kellyann.wolfswinkel', 'Role C'),
('lisanne.cole', 'Role B'),
('lisanne.cole', 'Role C'),
('lisanne.cole', 'Role D'),
('liva.deacon', 'Role A'),
('liva.deacon', 'Role C'),
('liva.deacon', 'Role D'),
('lucie.dear', 'Role D'),
('madison.stuttaford', 'Role C'),
('marieclaire.hickman', 'Role C'),
('martyn.bowen', 'Role B'),
('martyn.bowen', 'Role C'),
('michael.small', 'Role B'),
('michael.small', 'Role D'),
('nicholas.lewens', 'Role A'),
('nicholas.lewens', 'Role D'),
('olinda.stow', 'Role C'),
('patrisha.kegg', 'Admin'),
('patrisha.kegg', 'Role B'),
('pero.pym', 'Role A'),
('peter.makin', 'Role A'),
('rachael.brummitt', 'Role B'),
('rachael.brummitt', 'Role D'),
('rachel.gillone', 'Role A'),
('rachel.gillone', 'Role D'),
('ravi.thorhauge', 'Role C'),
('ravi.thorhauge', 'Role D'),
('robyn.jenett', 'Role C'),
('rosie.cutler', 'Role D'),
('sarah.hawes', 'Role C'),
('sarah.hawes', 'Role D'),
('sebastian.cahilly', 'Admin'),
('sebastian.cahilly', 'Role C'),
('sebastian.cahilly', 'Role D'),
('sharne.tremlett', 'Role B'),
('somjeet.jeramsilvey', 'Role D'),
('steven.sterry', 'Role D'),
('stuart.vulinovic', 'Role C'),
('thijs.watkins', 'Role B'),
('thijs.watkins', 'Role D'),
('velizar.melia', 'Role C'),
('wendy.lax', 'Role C'),
('wendy.lax', 'Role D');


ALTER TABLE `Employees`
  ADD PRIMARY KEY (`username`);


ALTER TABLE `Roles`
  ADD PRIMARY KEY (`username`,`role`);
COMMIT;

