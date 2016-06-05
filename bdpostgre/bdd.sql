--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.3
-- Dumped by pg_dump version 9.5.3

-- Started on 2016-06-05 19:51:48 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2197 (class 1262 OID 16384)
-- Name: acces; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE acces WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'fr_FR.UTF-8' LC_CTYPE = 'fr_FR.UTF-8';


ALTER DATABASE acces OWNER TO postgres;

\connect acces

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12403)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2200 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 185 (class 1259 OID 16410)
-- Name: collabo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE collabo (
    id integer NOT NULL,
    idperso integer NOT NULL,
    photo text,
    dateentree timestamp without time zone
);


ALTER TABLE collabo OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 16440)
-- Name: collabo_has_identifiant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE collabo_has_identifiant (
    idcollabo integer NOT NULL,
    ididentifiant integer NOT NULL
);


ALTER TABLE collabo_has_identifiant OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 16436)
-- Name: collabo_has_identifiant_idcollabo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE collabo_has_identifiant_idcollabo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE collabo_has_identifiant_idcollabo_seq OWNER TO postgres;

--
-- TOC entry 2201 (class 0 OID 0)
-- Dependencies: 188
-- Name: collabo_has_identifiant_idcollabo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE collabo_has_identifiant_idcollabo_seq OWNED BY collabo_has_identifiant.idcollabo;


--
-- TOC entry 189 (class 1259 OID 16438)
-- Name: collabo_has_identifiant_ididentifiant_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE collabo_has_identifiant_ididentifiant_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE collabo_has_identifiant_ididentifiant_seq OWNER TO postgres;

--
-- TOC entry 2202 (class 0 OID 0)
-- Dependencies: 189
-- Name: collabo_has_identifiant_ididentifiant_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE collabo_has_identifiant_ididentifiant_seq OWNED BY collabo_has_identifiant.ididentifiant;


--
-- TOC entry 183 (class 1259 OID 16406)
-- Name: collabo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE collabo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE collabo_id_seq OWNER TO postgres;

--
-- TOC entry 2203 (class 0 OID 0)
-- Dependencies: 183
-- Name: collabo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE collabo_id_seq OWNED BY collabo.id;


--
-- TOC entry 184 (class 1259 OID 16408)
-- Name: collabo_idperso_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE collabo_idperso_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE collabo_idperso_seq OWNER TO postgres;

--
-- TOC entry 2204 (class 0 OID 0)
-- Dependencies: 184
-- Name: collabo_idperso_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE collabo_idperso_seq OWNED BY collabo.idperso;


--
-- TOC entry 187 (class 1259 OID 16427)
-- Name: identifiant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE identifiant (
    id integer NOT NULL,
    empreinte text
);


ALTER TABLE identifiant OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 16425)
-- Name: identifiant_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE identifiant_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE identifiant_id_seq OWNER TO postgres;

--
-- TOC entry 2205 (class 0 OID 0)
-- Dependencies: 186
-- Name: identifiant_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE identifiant_id_seq OWNED BY identifiant.id;


--
-- TOC entry 192 (class 1259 OID 16467)
-- Name: logs; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE logs (
    id integer NOT NULL,
    log text,
    date timestamp without time zone
);


ALTER TABLE logs OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 16465)
-- Name: logs_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE logs_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE logs_id_seq OWNER TO postgres;

--
-- TOC entry 2206 (class 0 OID 0)
-- Dependencies: 191
-- Name: logs_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE logs_id_seq OWNED BY logs.id;


--
-- TOC entry 182 (class 1259 OID 16397)
-- Name: personnel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE personnel (
    id integer NOT NULL,
    nom text,
    prenom text,
    adresse text,
    statut text,
    login text,
    mdp text
);


ALTER TABLE personnel OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 16395)
-- Name: personnel_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE personnel_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE personnel_id_seq OWNER TO postgres;

--
-- TOC entry 2207 (class 0 OID 0)
-- Dependencies: 181
-- Name: personnel_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE personnel_id_seq OWNED BY personnel.id;


--
-- TOC entry 2060 (class 2604 OID 16413)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY collabo ALTER COLUMN id SET DEFAULT nextval('collabo_id_seq'::regclass);


--
-- TOC entry 2061 (class 2604 OID 16414)
-- Name: idperso; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY collabo ALTER COLUMN idperso SET DEFAULT nextval('collabo_idperso_seq'::regclass);


--
-- TOC entry 2063 (class 2604 OID 16443)
-- Name: idcollabo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY collabo_has_identifiant ALTER COLUMN idcollabo SET DEFAULT nextval('collabo_has_identifiant_idcollabo_seq'::regclass);


--
-- TOC entry 2064 (class 2604 OID 16444)
-- Name: ididentifiant; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY collabo_has_identifiant ALTER COLUMN ididentifiant SET DEFAULT nextval('collabo_has_identifiant_ididentifiant_seq'::regclass);


--
-- TOC entry 2062 (class 2604 OID 16430)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY identifiant ALTER COLUMN id SET DEFAULT nextval('identifiant_id_seq'::regclass);


--
-- TOC entry 2065 (class 2604 OID 16470)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY logs ALTER COLUMN id SET DEFAULT nextval('logs_id_seq'::regclass);


--
-- TOC entry 2059 (class 2604 OID 16400)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personnel ALTER COLUMN id SET DEFAULT nextval('personnel_id_seq'::regclass);


--
-- TOC entry 2073 (class 2606 OID 16446)
-- Name: collabo_has_identifiant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY collabo_has_identifiant
    ADD CONSTRAINT collabo_has_identifiant_pkey PRIMARY KEY (idcollabo, ididentifiant);


--
-- TOC entry 2069 (class 2606 OID 16419)
-- Name: collabo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY collabo
    ADD CONSTRAINT collabo_pkey PRIMARY KEY (id);


--
-- TOC entry 2071 (class 2606 OID 16435)
-- Name: identifiant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY identifiant
    ADD CONSTRAINT identifiant_pkey PRIMARY KEY (id);


--
-- TOC entry 2075 (class 2606 OID 16475)
-- Name: logs_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY logs
    ADD CONSTRAINT logs_pkey PRIMARY KEY (id);


--
-- TOC entry 2067 (class 2606 OID 16405)
-- Name: personnel_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personnel
    ADD CONSTRAINT personnel_pkey PRIMARY KEY (id);


--
-- TOC entry 2077 (class 2606 OID 16447)
-- Name: fk_collabo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY collabo_has_identifiant
    ADD CONSTRAINT fk_collabo FOREIGN KEY (idcollabo) REFERENCES collabo(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2078 (class 2606 OID 16452)
-- Name: fk_identifiant; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY collabo_has_identifiant
    ADD CONSTRAINT fk_identifiant FOREIGN KEY (ididentifiant) REFERENCES identifiant(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2076 (class 2606 OID 16420)
-- Name: fk_perso; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY collabo
    ADD CONSTRAINT fk_perso FOREIGN KEY (idperso) REFERENCES personnel(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2199 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-06-05 19:51:49 CEST

--
-- PostgreSQL database dump complete
--

