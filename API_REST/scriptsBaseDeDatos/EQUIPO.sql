CREATE TABLE F_EQUIPO
(
  PAIS_ID   INT ,  
  EQUIPO_ID INT          NOT NULL,
  EQUIPO    VARCHAR(50)  NOT NULL,
  API_ID    INT          NULL,
  LOGO_URL  VARCHAR(50)  NULL,		
  STATUS    VARCHAR(50)  NULL,	
Foreign Key (PAIS_ID) references F_PAIS(PAIS_ID)

);

