--
-- PostgreSQL database dump
--

-- Dumped from database version 9.2.5
-- Dumped by pg_dump version 9.2.5
-- Started on 2014-07-16 09:24:10

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 192 (class 3079 OID 11727)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2068 (class 0 OID 0)
-- Dependencies: 192
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 169 (class 1259 OID 100743)
-- Name: categorie; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE categorie (
    id_categorie integer NOT NULL,
    id_type integer,
    code character(256),
    libelle character(256),
    description character(256)
);


ALTER TABLE public.categorie OWNER TO postgres;

--
-- TOC entry 168 (class 1259 OID 100741)
-- Name: categorie_id_categorie_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE categorie_id_categorie_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categorie_id_categorie_seq OWNER TO postgres;

--
-- TOC entry 2069 (class 0 OID 0)
-- Dependencies: 168
-- Name: categorie_id_categorie_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE categorie_id_categorie_seq OWNED BY categorie.id_categorie;


--
-- TOC entry 171 (class 1259 OID 100754)
-- Name: commande; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE commande (
    id_commande integer NOT NULL,
    id_fournisseur integer,
    code character(256),
    type character(256),
    jour date,
    lib_jour character(256),
    description character(256),
    prix_total integer
);


ALTER TABLE public.commande OWNER TO postgres;

--
-- TOC entry 170 (class 1259 OID 100752)
-- Name: commande_id_commande_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE commande_id_commande_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.commande_id_commande_seq OWNER TO postgres;

--
-- TOC entry 2070 (class 0 OID 0)
-- Dependencies: 170
-- Name: commande_id_commande_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE commande_id_commande_seq OWNED BY commande.id_commande;


--
-- TOC entry 173 (class 1259 OID 100765)
-- Name: facture; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE facture (
    id_facture integer NOT NULL,
    id_fournisseur integer,
    description character(256),
    jour date,
    lib_jour character(256),
    credit integer,
    reglement integer,
    reste integer
);


ALTER TABLE public.facture OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 100763)
-- Name: facture_id_facture_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE facture_id_facture_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.facture_id_facture_seq OWNER TO postgres;

--
-- TOC entry 2071 (class 0 OID 0)
-- Dependencies: 172
-- Name: facture_id_facture_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE facture_id_facture_seq OWNED BY facture.id_facture;


--
-- TOC entry 175 (class 1259 OID 100776)
-- Name: fournisseur; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE fournisseur (
    id_fournisseur integer NOT NULL,
    code character(256),
    nom character(256),
    prenom character(256),
    adresse character(256),
    description character(256),
    telephone1 character(256),
    telephone2 character(256),
    credit integer
);


ALTER TABLE public.fournisseur OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 100774)
-- Name: fournisseur_id_fournisseur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE fournisseur_id_fournisseur_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.fournisseur_id_fournisseur_seq OWNER TO postgres;

--
-- TOC entry 2072 (class 0 OID 0)
-- Dependencies: 174
-- Name: fournisseur_id_fournisseur_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE fournisseur_id_fournisseur_seq OWNED BY fournisseur.id_fournisseur;


--
-- TOC entry 177 (class 1259 OID 100787)
-- Name: invite; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE invite (
    id_invite integer NOT NULL,
    jour date,
    lib_jour character(256),
    nombre integer,
    repat1 character(256),
    repat2 character(256),
    repat3 character(256),
    montant integer
);


ALTER TABLE public.invite OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 100785)
-- Name: invite_id_invite_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE invite_id_invite_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.invite_id_invite_seq OWNER TO postgres;

--
-- TOC entry 2073 (class 0 OID 0)
-- Dependencies: 176
-- Name: invite_id_invite_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE invite_id_invite_seq OWNED BY invite.id_invite;


--
-- TOC entry 179 (class 1259 OID 100798)
-- Name: ligne_commande; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ligne_commande (
    id_ligne_commande integer NOT NULL,
    id_commande integer,
    id_produit integer NOT NULL,
    quantite integer,
    prix_total integer
);


ALTER TABLE public.ligne_commande OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 100796)
-- Name: ligne_commande_id_ligne_commande_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ligne_commande_id_ligne_commande_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ligne_commande_id_ligne_commande_seq OWNER TO postgres;

--
-- TOC entry 2074 (class 0 OID 0)
-- Dependencies: 178
-- Name: ligne_commande_id_ligne_commande_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ligne_commande_id_ligne_commande_seq OWNED BY ligne_commande.id_ligne_commande;


--
-- TOC entry 181 (class 1259 OID 100806)
-- Name: parametre; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE parametre (
    id_parametre integer NOT NULL,
    libelle character(256),
    description character(256),
    valeur_entier integer,
    valeur_chaine character(256)
);


ALTER TABLE public.parametre OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 100804)
-- Name: parametre_id_parametre_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE parametre_id_parametre_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.parametre_id_parametre_seq OWNER TO postgres;

--
-- TOC entry 2075 (class 0 OID 0)
-- Dependencies: 180
-- Name: parametre_id_parametre_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE parametre_id_parametre_seq OWNED BY parametre.id_parametre;


--
-- TOC entry 183 (class 1259 OID 100817)
-- Name: produit; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE produit (
    id_produit integer NOT NULL,
    id_categorie integer,
    id_unite integer,
    code character(256),
    libelle character(256),
    stock integer,
    description character(256),
    ordre integer,
    prix integer
);


ALTER TABLE public.produit OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 100815)
-- Name: produit_id_produit_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE produit_id_produit_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.produit_id_produit_seq OWNER TO postgres;

--
-- TOC entry 2076 (class 0 OID 0)
-- Dependencies: 182
-- Name: produit_id_produit_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE produit_id_produit_seq OWNED BY produit.id_produit;


--
-- TOC entry 185 (class 1259 OID 100828)
-- Name: type; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE type (
    id_type integer NOT NULL,
    code character(256),
    libelle character(256),
    description character(256)
);


ALTER TABLE public.type OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 100826)
-- Name: type_id_type_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE type_id_type_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_id_type_seq OWNER TO postgres;

--
-- TOC entry 2077 (class 0 OID 0)
-- Dependencies: 184
-- Name: type_id_type_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE type_id_type_seq OWNED BY type.id_type;


--
-- TOC entry 187 (class 1259 OID 100839)
-- Name: unite; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE unite (
    id_unite integer NOT NULL,
    code character(256),
    libelle character(256),
    description character(256)
);


ALTER TABLE public.unite OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 100837)
-- Name: unite_id_unite_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE unite_id_unite_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.unite_id_unite_seq OWNER TO postgres;

--
-- TOC entry 2078 (class 0 OID 0)
-- Dependencies: 186
-- Name: unite_id_unite_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE unite_id_unite_seq OWNED BY unite.id_unite;


--
-- TOC entry 189 (class 1259 OID 100850)
-- Name: utilisateur; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE utilisateur (
    id_utilisateur integer NOT NULL,
    nom character(256),
    prenom character(256),
    login character(256),
    mot_passe character(256),
    niveau integer,
    telephone1 character(256),
    telephone2 character(256)
);


ALTER TABLE public.utilisateur OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 100848)
-- Name: utilisateur_id_utilisateur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE utilisateur_id_utilisateur_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.utilisateur_id_utilisateur_seq OWNER TO postgres;

--
-- TOC entry 2079 (class 0 OID 0)
-- Dependencies: 188
-- Name: utilisateur_id_utilisateur_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE utilisateur_id_utilisateur_seq OWNED BY utilisateur.id_utilisateur;


--
-- TOC entry 191 (class 1259 OID 100861)
-- Name: vendre; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE vendre (
    id_vendre integer NOT NULL,
    id_produit integer NOT NULL,
    id_fournisseur integer NOT NULL,
    prix integer
);


ALTER TABLE public.vendre OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 100859)
-- Name: vendre_id_vendre_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE vendre_id_vendre_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.vendre_id_vendre_seq OWNER TO postgres;

--
-- TOC entry 2080 (class 0 OID 0)
-- Dependencies: 190
-- Name: vendre_id_vendre_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE vendre_id_vendre_seq OWNED BY vendre.id_vendre;


--
-- TOC entry 1886 (class 2604 OID 100746)
-- Name: id_categorie; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY categorie ALTER COLUMN id_categorie SET DEFAULT nextval('categorie_id_categorie_seq'::regclass);


--
-- TOC entry 1887 (class 2604 OID 100757)
-- Name: id_commande; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY commande ALTER COLUMN id_commande SET DEFAULT nextval('commande_id_commande_seq'::regclass);


--
-- TOC entry 1888 (class 2604 OID 100768)
-- Name: id_facture; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY facture ALTER COLUMN id_facture SET DEFAULT nextval('facture_id_facture_seq'::regclass);


--
-- TOC entry 1889 (class 2604 OID 100779)
-- Name: id_fournisseur; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY fournisseur ALTER COLUMN id_fournisseur SET DEFAULT nextval('fournisseur_id_fournisseur_seq'::regclass);


--
-- TOC entry 1890 (class 2604 OID 100790)
-- Name: id_invite; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY invite ALTER COLUMN id_invite SET DEFAULT nextval('invite_id_invite_seq'::regclass);


--
-- TOC entry 1891 (class 2604 OID 100801)
-- Name: id_ligne_commande; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ligne_commande ALTER COLUMN id_ligne_commande SET DEFAULT nextval('ligne_commande_id_ligne_commande_seq'::regclass);


--
-- TOC entry 1892 (class 2604 OID 100809)
-- Name: id_parametre; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY parametre ALTER COLUMN id_parametre SET DEFAULT nextval('parametre_id_parametre_seq'::regclass);


--
-- TOC entry 1893 (class 2604 OID 100820)
-- Name: id_produit; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY produit ALTER COLUMN id_produit SET DEFAULT nextval('produit_id_produit_seq'::regclass);


--
-- TOC entry 1894 (class 2604 OID 100831)
-- Name: id_type; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY type ALTER COLUMN id_type SET DEFAULT nextval('type_id_type_seq'::regclass);


--
-- TOC entry 1895 (class 2604 OID 100842)
-- Name: id_unite; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY unite ALTER COLUMN id_unite SET DEFAULT nextval('unite_id_unite_seq'::regclass);


--
-- TOC entry 1896 (class 2604 OID 100853)
-- Name: id_utilisateur; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY utilisateur ALTER COLUMN id_utilisateur SET DEFAULT nextval('utilisateur_id_utilisateur_seq'::regclass);


--
-- TOC entry 1897 (class 2604 OID 100864)
-- Name: id_vendre; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY vendre ALTER COLUMN id_vendre SET DEFAULT nextval('vendre_id_vendre_seq'::regclass);


--
-- TOC entry 2038 (class 0 OID 100743)
-- Dependencies: 169
-- Data for Name: categorie; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2081 (class 0 OID 0)
-- Dependencies: 168
-- Name: categorie_id_categorie_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('categorie_id_categorie_seq', 3, true);


--
-- TOC entry 2040 (class 0 OID 100754)
-- Dependencies: 171
-- Data for Name: commande; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2082 (class 0 OID 0)
-- Dependencies: 170
-- Name: commande_id_commande_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('commande_id_commande_seq', 66, true);


--
-- TOC entry 2042 (class 0 OID 100765)
-- Dependencies: 173
-- Data for Name: facture; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2083 (class 0 OID 0)
-- Dependencies: 172
-- Name: facture_id_facture_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('facture_id_facture_seq', 1, false);


--
-- TOC entry 2044 (class 0 OID 100776)
-- Dependencies: 175
-- Data for Name: fournisseur; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2084 (class 0 OID 0)
-- Dependencies: 174
-- Name: fournisseur_id_fournisseur_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('fournisseur_id_fournisseur_seq', 5, true);


--
-- TOC entry 2046 (class 0 OID 100787)
-- Dependencies: 177
-- Data for Name: invite; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2085 (class 0 OID 0)
-- Dependencies: 176
-- Name: invite_id_invite_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('invite_id_invite_seq', 2, true);


--
-- TOC entry 2048 (class 0 OID 100798)
-- Dependencies: 179
-- Data for Name: ligne_commande; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2086 (class 0 OID 0)
-- Dependencies: 178
-- Name: ligne_commande_id_ligne_commande_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ligne_commande_id_ligne_commande_seq', 77, true);


--
-- TOC entry 2050 (class 0 OID 100806)
-- Dependencies: 181
-- Data for Name: parametre; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2087 (class 0 OID 0)
-- Dependencies: 180
-- Name: parametre_id_parametre_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('parametre_id_parametre_seq', 1, false);


--
-- TOC entry 2052 (class 0 OID 100817)
-- Dependencies: 183
-- Data for Name: produit; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2088 (class 0 OID 0)
-- Dependencies: 182
-- Name: produit_id_produit_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('produit_id_produit_seq', 5, true);


--
-- TOC entry 2054 (class 0 OID 100828)
-- Dependencies: 185
-- Data for Name: type; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2089 (class 0 OID 0)
-- Dependencies: 184
-- Name: type_id_type_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('type_id_type_seq', 3, true);


--
-- TOC entry 2056 (class 0 OID 100839)
-- Dependencies: 187
-- Data for Name: unite; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO unite (id_unite, code, libelle, description) VALUES (1, NULL, '1Kg                                                                                                                                                                                                                                                             ', 'Un Kilogramme                                                                                                                                                                                                                                                   ');
INSERT INTO unite (id_unite, code, libelle, description) VALUES (2, NULL, '1L                                                                                                                                                                                                                                                              ', 'Un litre                                                                                                                                                                                                                                                        ');


--
-- TOC entry 2090 (class 0 OID 0)
-- Dependencies: 186
-- Name: unite_id_unite_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('unite_id_unite_seq', 2, true);


--
-- TOC entry 2058 (class 0 OID 100850)
-- Dependencies: 189
-- Data for Name: utilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2091 (class 0 OID 0)
-- Dependencies: 188
-- Name: utilisateur_id_utilisateur_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('utilisateur_id_utilisateur_seq', 3, true);


--
-- TOC entry 2060 (class 0 OID 100861)
-- Dependencies: 191
-- Data for Name: vendre; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2092 (class 0 OID 0)
-- Dependencies: 190
-- Name: vendre_id_vendre_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('vendre_id_vendre_seq', 14, true);


--
-- TOC entry 1899 (class 2606 OID 100751)
-- Name: pk_categorie; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY categorie
    ADD CONSTRAINT pk_categorie PRIMARY KEY (id_categorie);


--
-- TOC entry 1901 (class 2606 OID 100762)
-- Name: pk_commande; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY commande
    ADD CONSTRAINT pk_commande PRIMARY KEY (id_commande);


--
-- TOC entry 1903 (class 2606 OID 100773)
-- Name: pk_facture; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY facture
    ADD CONSTRAINT pk_facture PRIMARY KEY (id_facture);


--
-- TOC entry 1905 (class 2606 OID 100784)
-- Name: pk_fournisseur; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY fournisseur
    ADD CONSTRAINT pk_fournisseur PRIMARY KEY (id_fournisseur);


--
-- TOC entry 1907 (class 2606 OID 100795)
-- Name: pk_invite; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY invite
    ADD CONSTRAINT pk_invite PRIMARY KEY (id_invite);


--
-- TOC entry 1909 (class 2606 OID 100803)
-- Name: pk_ligne_commande; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ligne_commande
    ADD CONSTRAINT pk_ligne_commande PRIMARY KEY (id_ligne_commande);


--
-- TOC entry 1911 (class 2606 OID 100814)
-- Name: pk_parametre; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY parametre
    ADD CONSTRAINT pk_parametre PRIMARY KEY (id_parametre);


--
-- TOC entry 1913 (class 2606 OID 100825)
-- Name: pk_produit; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY produit
    ADD CONSTRAINT pk_produit PRIMARY KEY (id_produit);


--
-- TOC entry 1915 (class 2606 OID 100836)
-- Name: pk_type; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY type
    ADD CONSTRAINT pk_type PRIMARY KEY (id_type);


--
-- TOC entry 1917 (class 2606 OID 100847)
-- Name: pk_unite; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY unite
    ADD CONSTRAINT pk_unite PRIMARY KEY (id_unite);


--
-- TOC entry 1919 (class 2606 OID 100858)
-- Name: pk_utilisateur; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY utilisateur
    ADD CONSTRAINT pk_utilisateur PRIMARY KEY (id_utilisateur);


--
-- TOC entry 1921 (class 2606 OID 100866)
-- Name: pk_vendre; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY vendre
    ADD CONSTRAINT pk_vendre PRIMARY KEY (id_vendre);


--
-- TOC entry 1922 (class 2606 OID 100867)
-- Name: fk_categori_regroupe_type; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY categorie
    ADD CONSTRAINT fk_categori_regroupe_type FOREIGN KEY (id_type) REFERENCES type(id_type) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1923 (class 2606 OID 100872)
-- Name: fk_commande_implique_fourniss; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY commande
    ADD CONSTRAINT fk_commande_implique_fourniss FOREIGN KEY (id_fournisseur) REFERENCES fournisseur(id_fournisseur) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1924 (class 2606 OID 100877)
-- Name: fk_facture_benificie_fourniss; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY facture
    ADD CONSTRAINT fk_facture_benificie_fourniss FOREIGN KEY (id_fournisseur) REFERENCES fournisseur(id_fournisseur) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1925 (class 2606 OID 100882)
-- Name: fk_ligne_co_compter_produit; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ligne_commande
    ADD CONSTRAINT fk_ligne_co_compter_produit FOREIGN KEY (id_produit) REFERENCES produit(id_produit) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1926 (class 2606 OID 100887)
-- Name: fk_ligne_co_detenir_commande; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ligne_commande
    ADD CONSTRAINT fk_ligne_co_detenir_commande FOREIGN KEY (id_commande) REFERENCES commande(id_commande) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1927 (class 2606 OID 100892)
-- Name: fk_produit_avoir_categori; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY produit
    ADD CONSTRAINT fk_produit_avoir_categori FOREIGN KEY (id_categorie) REFERENCES categorie(id_categorie) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1928 (class 2606 OID 100897)
-- Name: fk_produit_possede_unite; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY produit
    ADD CONSTRAINT fk_produit_possede_unite FOREIGN KEY (id_unite) REFERENCES unite(id_unite) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1930 (class 2606 OID 100907)
-- Name: fk_vendre_vendre2_produit; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY vendre
    ADD CONSTRAINT fk_vendre_vendre2_produit FOREIGN KEY (id_produit) REFERENCES produit(id_produit) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1929 (class 2606 OID 100902)
-- Name: fk_vendre_vendre_fourniss; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY vendre
    ADD CONSTRAINT fk_vendre_vendre_fourniss FOREIGN KEY (id_fournisseur) REFERENCES fournisseur(id_fournisseur) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2067 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2014-07-16 09:24:11

--
-- PostgreSQL database dump complete
--

