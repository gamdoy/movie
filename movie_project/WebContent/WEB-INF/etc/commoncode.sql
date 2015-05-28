--성별
insert into COMMONCODE values ('100000', 'gender', '성별');
insert into COMMONCODE values ('100100', 'male', '남성');
insert into COMMONCODE values ('100200', 'female', '여성');

--전화번호
insert into COMMONCODE values ('101000', 'phoneType', '번호');
insert into COMMONCODE values ('101100', '010', '010');
insert into COMMONCODE values ('101200', '011', '011');
insert into COMMONCODE values ('101300', '016', '016');
insert into COMMONCODE values ('101400', '019', '019');
insert into COMMONCODE values ('101500', '070', '070');

--회원분류
insert into COMMONCODE values ('102000', 'memberType', '회원분류');
insert into COMMONCODE values ('102100', 'normal', '회원');
insert into COMMONCODE values ('102200', 'VIP', 'VIP');
insert into COMMONCODE values ('102300', 'admin', '관리자');

--쿠폰사용유무
insert into COMMONCODE values ('103000', 'useType', '쿠폰사용여부');
insert into COMMONCODE values ('103100', 'notUsed', '미사용');
insert into COMMONCODE values ('103200', 'used', '사용');
insert into COMMONCODE values ('103300', 'expried', '만료');

--상영등급 SCREENINGGRADE
insert into COMMONCODE values ('104000', 'screeninggrade', '상영등급');
insert into COMMONCODE values ('104100', 'all', '전체관람가');
insert into COMMONCODE values ('104200', 'r-12', '12세 관람가');
insert into COMMONCODE values ('104300', 'r-15', '15세 관람가');
insert into COMMONCODE values ('104400', 'r-19', '성인 관람가');

--비밀여부(게시글)
insert into COMMONCODE values ('105000', 'secretType', '공개여부');
insert into COMMONCODE values ('105100', 'public', '공개');
insert into COMMONCODE values ('105200', 'private', '비공개');

--QA 진행상태
insert into COMMONCODE values ('106000', 'statusType', '진행상태');
insert into COMMONCODE values ('106100', 'unconfirm', '미확인');
insert into COMMONCODE values ('106200', 'checking', '확인중');
insert into COMMONCODE values ('106300', 'complete', '답변완료');

--상영관번호
insert into COMMONCODE values ('107000', 'theaterNo', '상영관');
insert into COMMONCODE values ('107100', '1stTheater', '1관');
insert into COMMONCODE values ('107200', '2ndTheater', '2관');
insert into COMMONCODE values ('107300', '3rdTheater', '3관');
insert into COMMONCODE values ('107400', '4thTheater', '4관');
insert into COMMONCODE values ('107500', '5thTheater', '5관');
insert into COMMONCODE values ('107600', '6thTheater', '6관');

--결제타입 PAYTYPE
insert into COMMONCODE values ('108000', 'payType', '결제타입');
insert into COMMONCODE values ('108100', 'passbook', '무통장 결제');
insert into COMMONCODE values ('108200', 'card', '카드 결제');
insert into COMMONCODE values ('108300', 'phone', '휴대폰 결제');

--상영타입 SCREENTYPE
insert into COMMONCODE values ('109000', 'screenType', '상영타입');
insert into COMMONCODE values ('109100', '2DScreen', '일반 상영관');
insert into COMMONCODE values ('109200', '3DScreen', '3D 상영관');
insert into COMMONCODE values ('109300', '4DScreen', '4D 상영관');
insert into COMMONCODE values ('109400', 'imaxScreen', 'IMAX 상영관');

--장르타입 genreTYPE
insert into COMMONCODE values ('110000', 'genreType', '장르타입');
insert into COMMONCODE values ('110100', 'action', '액션');
insert into COMMONCODE values ('110200', 'horror', '공포');
insert into COMMONCODE values ('110300', 'melo', '멜로');
insert into COMMONCODE values ('110400', 'romance', '로맨스');
insert into COMMONCODE values ('110500', 'COMEDY', '코미디');
insert into COMMONCODE values ('110600', 'SF', 'SF');