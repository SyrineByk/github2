/*==============================================================*/
/* Nom de SGBD :  PostgreSQL 8                                  */
/* Date de création :  07/07/2014 18:32:22                      */
/*==============================================================*/


drop table CATEGORIE;

drop table COMMANDE;

drop table FACTURE;

drop table FOURNISSEUR;

drop table INVITE;

drop table LIGNE_COMMANDE;

drop table PARAMETRE;

drop table PRODUIT;

drop table TYPE;

drop table UNITE;

drop table UTILISATEUR;

drop table VENDRE;

/*==============================================================*/
/* Table : CATEGORIE                                            */
/*==============================================================*/
create table CATEGORIE (
   ID_CATEGORIE         SERIAL               not null,
   ID_TYPE              INT4                 null,
   CODE                 CHAR(256)            null,
   LIBELLE              CHAR(256)            null,
   DESCRIPTION          CHAR(256)            null,
   constraint PK_CATEGORIE primary key (ID_CATEGORIE)
);

/*==============================================================*/
/* Table : COMMANDE                                             */
/*==============================================================*/
create table COMMANDE (
   ID_COMMANDE          SERIAL               not null,
   ID_FOURNISSEUR       INT4                 null,
   CODE                 CHAR(256)            null,
   TYPE                 CHAR(256)            null,
   JOUR                 DATE                 null,
   LIB_JOUR             CHAR(256)            null,
   DESCRIPTION          CHAR(256)            null,
   PRIX_TOTAL           INT4                 null,
   constraint PK_COMMANDE primary key (ID_COMMANDE)
);

/*==============================================================*/
/* Table : FACTURE                                              */
/*==============================================================*/
create table FACTURE (
   ID_FACTURE           SERIAL               not null,
   ID_FOURNISSEUR       INT4                 null,
   DESCRIPTION          CHAR(256)            null,
   JOUR                 DATE                 null,
   LIB_JOUR             CHAR(256)            null,
   CREDIT               INT4                 null,
   REGLEMENT            INT4                 null,
   RESTE                INT4                 null,
   constraint PK_FACTURE primary key (ID_FACTURE)
);

/*==============================================================*/
/* Table : FOURNISSEUR                                          */
/*==============================================================*/
create table FOURNISSEUR (
   ID_FOURNISSEUR       SERIAL               not null,
   CODE                 CHAR(256)            null,
   NOM                  CHAR(256)            null,
   PRENOM               CHAR(256)            null,
   ADRESSE              CHAR(256)            null,
   DESCRIPTION          CHAR(256)            null,
   TELEPHONE1           CHAR(256)            null,
   TELEPHONE2           CHAR(256)            null,
   CREDIT               INT4                 null,
   constraint PK_FOURNISSEUR primary key (ID_FOURNISSEUR)
);

/*==============================================================*/
/* Table : INVITE                                               */
/*==============================================================*/
create table INVITE (
   ID_INVITE            SERIAL               not null,
   JOUR                 DATE                 null,
   LIB_JOUR             CHAR(256)            null,
   NOMBRE               INT4                 null,
   REPAT1               CHAR(256)            null,
   REPAT2               CHAR(256)            null,
   REPAT3               CHAR(256)            null,
   MONTANT              INT4                 null,
   constraint PK_INVITE primary key (ID_INVITE)
);

/*==============================================================*/
/* Table : LIGNE_COMMANDE                                       */
/*==============================================================*/
create table LIGNE_COMMANDE (
   ID_LIGNE_COMMANDE    SERIAL               not null,
   ID_COMMANDE          INT4                 null,
   ID_PRODUIT           INT4                 not null,
   QUANTITE             INT4                 null,
   PRIX_TOTAL           INT4                 null,
   constraint PK_LIGNE_COMMANDE primary key (ID_LIGNE_COMMANDE)
);

/*==============================================================*/
/* Table : PARAMETRE                                            */
/*==============================================================*/
create table PARAMETRE (
   ID_PARAMETRE         SERIAL               not null,
   LIBELLE              CHAR(256)            null,
   DESCRIPTION          CHAR(256)            null,
   VALEUR_ENTIER        INT4                 null,
   VALEUR_CHAINE        CHAR(256)            null,
   constraint PK_PARAMETRE primary key (ID_PARAMETRE)
);

/*==============================================================*/
/* Table : PRODUIT                                              */
/*==============================================================*/
create table PRODUIT (
   ID_PRODUIT           SERIAL               not null,
   ID_CATEGORIE         INT4                 null,
   ID_UNITE             INT4                 null,
   CODE                 CHAR(256)            null,
   LIBELLE              CHAR(256)            null,
   STOCK                INT4                 null,
   DESCRIPTION          CHAR(256)            null,
   ORDRE                INT4                 null,
   PRIX                 INT4                 null,
   constraint PK_PRODUIT primary key (ID_PRODUIT)
);

/*==============================================================*/
/* Table : TYPE                                                 */
/*==============================================================*/
create table TYPE (
   ID_TYPE              SERIAL               not null,
   CODE                 CHAR(256)            null,
   LIBELLE              CHAR(256)            null,
   DESCRIPTION          CHAR(256)            null,
   constraint PK_TYPE primary key (ID_TYPE)
);

/*==============================================================*/
/* Table : UNITE                                                */
/*==============================================================*/
create table UNITE (
   ID_UNITE             SERIAL               not null,
   CODE                 CHAR(256)            null,
   LIBELLE              CHAR(256)            null,
   DESCRIPTION          CHAR(256)            null,
   constraint PK_UNITE primary key (ID_UNITE)
);

/*==============================================================*/
/* Table : UTILISATEUR                                          */
/*==============================================================*/
create table UTILISATEUR (
   ID_UTILISATEUR       SERIAL               not null,
   NOM                  CHAR(256)            null,
   PRENOM               CHAR(256)            null,
   LOGIN                CHAR(256)            null,
   MOT_PASSE            CHAR(256)            null,
   NIVEAU               INT4                 null,
   TELEPHONE1           CHAR(256)            null,
   TELEPHONE2           CHAR(256)            null,
   constraint PK_UTILISATEUR primary key (ID_UTILISATEUR)
);

/*==============================================================*/
/* Table : VENDRE                                               */
/*==============================================================*/
create table VENDRE (
   ID_VENDRE            SERIAL               not null,
   ID_PRODUIT           INT4                 not null,
   ID_FOURNISSEUR       INT4                 not null,
   PRIX                 INT4                 null,
   constraint PK_VENDRE primary key (ID_VENDRE)
);

alter table CATEGORIE
   add constraint FK_CATEGORI_REGROUPE_TYPE foreign key (ID_TYPE)
      references TYPE (ID_TYPE)
      on delete restrict on update restrict;

alter table COMMANDE
   add constraint FK_COMMANDE_IMPLIQUE_FOURNISS foreign key (ID_FOURNISSEUR)
      references FOURNISSEUR (ID_FOURNISSEUR)
      on delete restrict on update restrict;

alter table FACTURE
   add constraint FK_FACTURE_BENIFICIE_FOURNISS foreign key (ID_FOURNISSEUR)
      references FOURNISSEUR (ID_FOURNISSEUR)
      on delete restrict on update restrict;

alter table LIGNE_COMMANDE
   add constraint FK_LIGNE_CO_COMPTER_PRODUIT foreign key (ID_PRODUIT)
      references PRODUIT (ID_PRODUIT)
      on delete restrict on update restrict;

alter table LIGNE_COMMANDE
   add constraint FK_LIGNE_CO_DETENIR_COMMANDE foreign key (ID_COMMANDE)
      references COMMANDE (ID_COMMANDE)
      on delete restrict on update restrict;

alter table PRODUIT
   add constraint FK_PRODUIT_AVOIR_CATEGORI foreign key (ID_CATEGORIE)
      references CATEGORIE (ID_CATEGORIE)
      on delete restrict on update restrict;

alter table PRODUIT
   add constraint FK_PRODUIT_POSSEDE_UNITE foreign key (ID_UNITE)
      references UNITE (ID_UNITE)
      on delete restrict on update restrict;

alter table VENDRE
   add constraint FK_VENDRE_VENDRE_FOURNISS foreign key (ID_FOURNISSEUR)
      references FOURNISSEUR (ID_FOURNISSEUR)
      on delete restrict on update restrict;

alter table VENDRE
   add constraint FK_VENDRE_VENDRE2_PRODUIT foreign key (ID_PRODUIT)
      references PRODUIT (ID_PRODUIT)
      on delete restrict on update restrict;

