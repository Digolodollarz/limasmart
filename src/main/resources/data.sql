INSERT IGNORE INTO role (role_id, role) VALUES
  (1, 'USER'),
  (2, 'ADMIN'),
  (3, 'DRIVER');

INSERT IGNORE INTO `disease` (`number`, `crop`, `disease`, `rainfall`, `temperature`, `radiation`, `moisture`, `humidity`, `windspeed`, `sympton`, `chemical`, `price`)
VALUES
  (0, 'maize', 'common rust\r\n', 30, 24, 2000, 7, 96, 20, 'brownish red pustules\r\n', 'fungicide', 15),
  (1, 'maize', 'eye spot\r\n', 25, 11, 5000, 6, 50, 20, 'circular lesions  with tan creamed centre\r\n', 'fungicide', 15),
  (2, 'maize', 'erwinia stalk rot\r\n', 40, 33, 3000, 7, 90, 5, 'foul smell of diseased slimy plants\r\n', 'Nitrates Alkali', 20),
  (3, 'wheat', 'white_heads\r\n', 10, 25, 50000, 5, 90, 5, 'premature bleaching of infected heads while leaves remain green\r\n', 'fungicide', 15),
  (4, 'wheat', 'powdery mildew\r\n', 25, 18, 1000, 7, 80, 20, 'white powdery stuff ; leaves  might die\r\n', 'fungicide', 15),
  (5, 'wheat', 'septoria blotch\r\n', 30, 12, 1000, 7, 70, 5, 'irregular spots  yellow  ;leaves may die\r\n', 'fungicide', 15),
  (6, 'sunflower', 'apical chlorosis\r\n', 50, 28, 1000, 9, 805, 5, 'yellowing  of leaves usually on one side of plant\r\n', 'fungicide', 15),
  (7, 'sunflower', 'charcoal rot ', 5, 35, 100000, 3, 20, 5, 'greyish white spots on the top of leaf surface powdery white appearance on leaves\r\n', 'fungicide', 15),
  (8, 'sunflower', 'white blister rust\r\n', 25, 12, 50000, 6, 90, 5, 'yellow isolated spots \r\n', 'fungicide', 15),
  (9, 'goat', 'enterotoxemia\r\n', 25, 28, 50000, 6, 90, 5, 'consitpation  followed by diarrhoea\r\n', 'antitoxin', 30),
  (10, 'goat', 'pneumonia\r\n', 20, 28, 80000, 6, 80, 5, 'dullness; failing appetite ;fever difficulty breathing\r\n', 'administer a decongestant and anti-histaminic drugs;airate kraal\r\n', 16),
  (11, 'goat', 'tetanus\r\n', 35, 27, 20000, 7, 50, 5, 'difficulty in swallowing stiff muscle muscle spasm\r\n',
       'tetanus toxoid\r\n', 41),
  (12, 'cattle', 'blacleg', 25, 27, 20000, 7, 50, 5, 'lameness fever swelling of hip shoulder and back \r\n',
       ' vaccine, penicilin burn top soil in kraal\r\n', 17),
  (13, 'cattle', 'foot rot ', 40, 27, 10000, 7, 40, 5,
       'diffulty breathing eating  yello patch on tongue gums;nasala discharge\r\n',
       'daily procaine penicillin by intramuscular injection for 5 to 7 consecutive days as directed by your veterinary surgeon\r\n',
   24),
  (14, 'chicken', 'pollurum', 30, 27, 10000, 7, 40, 5,
       'huddling of chicks; eyes closed ;wings drooped;foamy droppings \r\n',
       'buy certified chicks ,blood test required\r\n', 14),
  (15, 'chicken', 'gumboro', 30, 28, 10000, 7, 80, 5, 'watery diarrhoea; inflamation of cloaca\r\n',
       'multivitamin supplement and facilitating access to water\r\n', 8),
  (16, 'chicken \r\n', 'fowl pox\r\n', 30, 30, 1000, 7, 75, 5, 'swollen eylids;soiled feathers closure of eyes\r\n',
       'disinfection and vaccine\r\n', 23);
