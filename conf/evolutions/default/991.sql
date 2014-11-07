-- phpMyAdmin SQL Dump
-- version 3.5.5
-- http://www.phpmyadmin.net
--
-- ホスト: localhost
-- 生成日時: 2014 年 11 月 07 日 17:53
-- サーバのバージョン: 5.5.29
-- PHP のバージョン: 5.4.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- データベース: `recruit`
--

--
-- テーブルのデータのダンプ `category`
--

INSERT INTO `category` (`category_id`, `title`, `sort_order`, `create_date`, `update_date`) VALUES(1, 'IT／通信／インターネット', 1, '2014-03-05 23:45:06', '2014-03-05 23:45:06');
INSERT INTO `category` (`category_id`, `title`, `sort_order`, `create_date`, `update_date`) VALUES(2, 'メディア', 10, '2014-03-05 23:45:06', '2014-03-05 23:45:06');
INSERT INTO `category` (`category_id`, `title`, `sort_order`, `create_date`, `update_date`) VALUES(3, '金融', 20, '2014-03-05 23:45:43', '2014-03-05 23:45:43');
INSERT INTO `category` (`category_id`, `title`, `sort_order`, `create_date`, `update_date`) VALUES(4, 'メディカル', 30, '2014-03-05 23:45:43', '2014-03-05 23:45:43');
INSERT INTO `category` (`category_id`, `title`, `sort_order`, `create_date`, `update_date`) VALUES(5, 'メーカー', 40, '2014-03-05 23:46:12', '2014-03-05 23:46:12');
INSERT INTO `category` (`category_id`, `title`, `sort_order`, `create_date`, `update_date`) VALUES(6, '商社／流通', 50, '2014-03-05 23:46:12', '2014-03-05 23:46:12');
INSERT INTO `category` (`category_id`, `title`, `sort_order`, `create_date`, `update_date`) VALUES(7, '小売／外食', 60, '2014-03-05 23:46:48', '2014-03-05 23:46:48');
INSERT INTO `category` (`category_id`, `title`, `sort_order`, `create_date`, `update_date`) VALUES(8, 'サービス', 70, '2014-03-05 23:46:48', '2014-03-05 23:46:48');
INSERT INTO `category` (`category_id`, `title`, `sort_order`, `create_date`, `update_date`) VALUES(9, 'その他', 999, '2014-03-05 23:47:20', '2014-03-05 23:47:20');
INSERT INTO `category` (`category_id`, `title`, `sort_order`, `create_date`, `update_date`) VALUES(10, '未分類', 0, '2014-03-05 23:47:20', '2014-03-05 23:47:20');

--
-- テーブルのデータのダンプ `company`
--

INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(1, 'リクルートホールディングス', '2014-11-08 00:00:11', '2014-11-08 00:00:11');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(2, 'リクルートマーケティングパートナーズ', '2014-11-08 00:06:13', '2014-11-08 00:06:13');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(3, '伊藤ハム', '2014-11-08 00:11:59', '2014-11-08 00:11:59');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(4, '株式会社ジェイアイエヌ', '2014-11-08 00:26:49', '2014-11-08 00:26:49');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(5, 'JCB', '2014-11-08 00:27:55', '2014-11-08 00:27:55');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(6, 'オーシャン貿易株式会社', '2014-11-08 00:29:23', '2014-11-08 00:29:23');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(7, '中国電力', '2014-11-08 00:33:12', '2014-11-08 00:33:12');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(8, '楽天株式会社', '2014-11-08 00:34:28', '2014-11-08 00:34:28');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(9, '阪急阪神エクスプレス', '2014-11-08 00:36:43', '2014-11-08 00:36:43');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(10, 'ITS', '2014-11-08 00:39:24', '2014-11-08 00:39:24');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(11, '株式会社リアホールディングス', '2014-11-08 00:42:45', '2014-11-08 00:42:45');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(12, '船井総合研究所', '2014-11-08 00:45:42', '2014-11-08 00:45:42');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(13, 'KOSE', '2014-11-08 00:47:23', '2014-11-08 00:47:23');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(14, '昭和病院', '2014-11-08 01:10:39', '2014-11-08 01:10:39');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(15, 'リクルートライフスタイル', '2014-11-08 01:12:25', '2014-11-08 01:12:25');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(16, 'ＳＭＢＣ日興証券', '2014-11-08 01:17:15', '2014-11-08 01:17:15');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(17, '三井食品株式会社', '2014-11-08 01:21:39', '2014-11-08 01:21:39');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(18, '三菱重工', '2014-11-08 01:23:12', '2014-11-08 01:23:12');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(19, '青山メインランド', '2014-11-08 01:26:49', '2014-11-08 01:26:49');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(20, 'リクルートコミュニケーションズ', '2014-11-08 01:29:27', '2014-11-08 01:29:27');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(21, '株式会社Cygames', '2014-11-08 01:32:10', '2014-11-08 01:32:10');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(22, 'ソフトバンク', '2014-11-08 01:33:56', '2014-11-08 01:33:56');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(23, '株式会社USEN', '2014-11-08 01:36:19', '2014-11-08 01:36:19');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(24, '花王株式会社', '2014-11-08 01:39:52', '2014-11-08 01:39:52');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(25, '株式会社サイバーエージェント', '2014-11-08 01:43:29', '2014-11-08 01:43:29');
INSERT INTO `company` (`company_id`, `title`, `create_date`, `update_date`) VALUES(26, '株式会社マクロミル', '2014-11-08 01:44:35', '2014-11-08 01:44:35');

--
-- テーブルのデータのダンプ `site`
--

INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(1, '長尾 美樹｜プロダクトマネジャー｜RECRUIT HOLDINGS-リクルートホールディングス-｜Web職種サイト', 'http://recruit-jinji.jp/work/work03.html', 8, 1, '2014-11-08 00:00:11', '2014-11-08 00:00:11');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(2, '働く女性として。二児の母として。解決したい社会課題がある。｜[新卒採用]リクルートマーケティングパートナーズ-Recruit Marketing Partners-', 'http://www.recruit-mp.co.jp/fresh/2015/member/interview/detail_08.html', 1, 2, '2014-11-08 00:06:13', '2014-11-08 01:02:54');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(3, '花嫁の「不」を解消し、未来に笑顔を増やしたい｜[新卒採用]リクルートマーケティングパートナーズ-Recruit Marketing Partners-', 'http://www.recruit-mp.co.jp/fresh/2015/member/interview/detail_02.html', 1, 2, '2014-11-08 00:07:39', '2014-11-08 01:03:24');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(4, '日々の頑張りが、誰かの歓びにつながっている。実感できるから、また、頑張れる。｜[新卒採用]リクルートマーケティングパートナーズ-Recruit Marketing Partners-', 'http://www.recruit-mp.co.jp/fresh/2015/member/interview/detail_05.html', 1, 2, '2014-11-08 00:08:07', '2014-11-08 01:04:12');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(5, '伊藤ハムグループ　採用情報2015｜先輩の声：下見 光奈', 'http://www.itoham.co.jp/corporate/company/saiyo/voice/10_hananoi.html', 7, 3, '2014-11-08 00:11:59', '2014-11-08 01:04:28');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(6, '伊藤ハムグループ　採用情報2015｜先輩の声：池上 朋子', 'http://www.itoham.co.jp/corporate/company/saiyo/voice/05_ikegami.html', 7, 3, '2014-11-08 00:24:22', '2014-11-08 01:04:48');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(7, '伊藤ハムグループ　採用情報2015｜先輩の声：吉川 菜緒', 'http://www.itoham.co.jp/corporate/company/saiyo/voice/02_yoshikawa.html', 7, 3, '2014-11-08 00:24:39', '2014-11-08 01:05:52');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(8, '官野里菜 - 先輩紹介 - 新卒採用 | 株式会社ジェイアイエヌ', 'http://www.jin-co.com/recruit/new/people/office/kanno.html', 7, 4, '2014-11-08 00:26:49', '2014-11-08 01:06:10');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(9, 'ワークライフバランス/社員の声 | JCB新卒採用情報', 'http://www.saiyo.jcb.co.jp/career/worklife_3.html', 3, 5, '2014-11-08 00:27:55', '2014-11-08 01:06:51');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(10, '先輩社員の声：松岡 由怜 | 社員を知る | 2015年度新卒採用情報 | オーシャン貿易株式会社', 'http://www.oceantrading.co.jp/recruit/staff/05/', 6, 6, '2014-11-08 00:29:23', '2014-11-08 01:07:27');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(11, '竹下 沙織│先輩社員の声│中国電力', 'http://www.energia.co.jp/recruit/sin/work/message/takeshita.html', 9, 7, '2014-11-08 00:33:12', '2014-11-08 01:07:44');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(12, '楽天株式会社: 営業コンサルタント Tomomi: 社員紹介 < 採用情報', 'http://corp.rakuten.co.jp/careers/work/member/sales-consultant-tomomi.html', 1, 8, '2014-11-08 00:34:28', '2014-11-08 01:07:59');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(13, '楽天株式会社: 事業・サービス企画 Mei: 社員紹介 < 採用情報', 'http://corp.rakuten.co.jp/careers/work/member/business-service-planning-mei.html', 1, 8, '2014-11-08 00:35:01', '2014-11-08 01:09:06');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(14, '牧 真菜美｜先輩社員紹介｜阪急阪神エクスプレス2015年度採用サイト', 'http://www.hh-express.com/jp/recruit/career/maki.html', 6, 9, '2014-11-08 00:36:43', '2014-11-08 01:09:21');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(15, '伏見 沙織｜先輩社員紹介｜阪急阪神エクスプレス2015年度採用サイト', 'http://www.hh-express.com/jp/recruit/career/fushimi.html', 6, 9, '2014-11-08 00:37:31', '2014-11-08 01:09:38');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(16, '中本 美香｜先輩社員紹介｜阪急阪神エクスプレス2015年度採用サイト', 'http://www.hh-express.com/jp/recruit/career/nakamoto.html', 6, 9, '2014-11-08 00:37:56', '2014-11-08 01:01:08');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(17, 'ITS RECRUITING SITE / 先輩社員インタビュー', 'http://www.itsnet.co.jp/newgraduate/contents/interview/YK.htm', 1, 10, '2014-11-08 00:39:24', '2014-11-08 00:54:20');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(18, '株式会社リアホールディングス 2015年新卒採用サイト', 'http://reaholdings.co.jp/recruit/interview/detail09/', 9, 11, '2014-11-08 00:42:45', '2014-11-08 00:54:00');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(19, '株式会社リアホールディングス 2014年新卒採用サイト', 'http://reaholdings.co.jp/recruit/interview/detail05/', 9, 11, '2014-11-08 00:42:59', '2014-11-08 00:53:42');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(20, '株式会社リアホールディングス 2015年新卒採用サイト', 'http://reaholdings.co.jp/recruit/interview/detail08/', 9, 11, '2014-11-08 00:43:12', '2014-11-08 00:53:16');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(21, '村田 泰子｜先輩社員インタビュー｜新卒採用2016｜船井総合研究所', 'http://www.funaisoken.jp/recruite/newgraduate/interview/murata.html', 8, 12, '2014-11-08 00:45:42', '2014-11-08 00:52:41');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(22, '先輩の声 | KOSE採用情報', 'https://www.kose.co.jp/jp/ja/recruit/voice/sales/09.html', 5, 13, '2014-11-08 00:47:23', '2014-11-08 00:51:58');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(23, '先輩の声 | KOSE採用情報', 'https://www.kose.co.jp/jp/ja/recruit/voice/marketing/01.html', 5, 13, '2014-11-08 00:47:40', '2014-11-08 00:51:40');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(24, '先輩の声 | KOSE採用情報', 'https://www.kose.co.jp/jp/ja/recruit/voice/marketing/02.html', 5, 13, '2014-11-08 00:48:11', '2014-11-08 00:48:11');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(25, '先輩の声 | KOSE採用情報', 'https://www.kose.co.jp/jp/ja/recruit/voice/sales/05.html', 5, 13, '2014-11-08 00:48:35', '2014-11-08 00:48:35');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(26, '先輩の声 | KOSE採用情報', 'https://www.kose.co.jp/jp/ja/recruit/voice/lab/01.html', 5, 13, '2014-11-08 00:48:59', '2014-11-08 00:48:59');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(27, '先輩の声 | KOSE採用情報', 'https://www.kose.co.jp/jp/ja/recruit/voice/admin/01.html', 5, 13, '2014-11-08 00:49:23', '2014-11-08 00:49:23');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(28, '患者さんの心も体も支える介護を｜先輩の声｜特定医療法人 茜会 昭和病院 採用情報サイト', 'http://www.akanekai-showa.com/archives/voice/1089', 4, 14, '2014-11-08 01:10:39', '2014-11-08 01:10:39');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(29, '社員紹介｜新卒採用 リクルートライフスタイル RECRUIT LIFESTYLE', 'http://www.shinsotsu.recruit-lifestyle.co.jp/member/#!member26', 1, 15, '2014-11-08 01:12:25', '2014-11-08 01:12:25');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(30, '社員紹介｜新卒採用 リクルートライフスタイル RECRUIT LIFESTYLE', 'http://www.shinsotsu.recruit-lifestyle.co.jp/member/#!member08', 1, 15, '2014-11-08 01:13:15', '2014-11-08 01:13:15');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(31, '社員紹介｜新卒採用 リクルートライフスタイル RECRUIT LIFESTYLE', 'http://www.shinsotsu.recruit-lifestyle.co.jp/member/#!member24', 1, 15, '2014-11-08 01:14:59', '2014-11-08 01:14:59');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(32, '橋本 磨利亜｜社員紹介｜ＳＭＢＣ日興証券', 'http://www.smbcnikko.co.jp/recruit/student/2016/person/hashimoto.html', 3, 16, '2014-11-08 01:17:15', '2014-11-08 01:17:15');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(33, '松川 浩美｜社員の仕事｜ＳＭＢＣ日興証券', 'http://www.smbcnikko.co.jp/recruit/student/2015/person/19.html', 3, 16, '2014-11-08 01:17:47', '2014-11-08 01:17:47');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(34, '森本　さや | 先輩社員の声 | 会社紹介 | リクルート2015 | 三井食品株式会社', 'http://www.mitsuifoods.co.jp/recruit2015/company/interview/01.html', 5, 17, '2014-11-08 01:21:39', '2014-11-08 01:21:39');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(35, '三菱重工 | 新卒採用 | 社員インタビュー | 先輩社員インタビュー | 中嶋美夏', 'http://www.mhi.co.jp/recruit/shinsotsu/interview/senior/interview12.html', 5, 18, '2014-11-08 01:23:12', '2014-11-08 01:23:12');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(36, '三菱重工 | 新卒採用 | 社員インタビュー | 先輩社員インタビュー | 高山真季', 'http://www.mhi.co.jp/recruit/shinsotsu/interview/senior/interview17.html', 5, 18, '2014-11-08 01:24:08', '2014-11-08 01:24:08');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(37, 'ベテラン社員インタビュー 大河 蘭｜青山メインランド新卒採用スペシャルサイト', 'http://recruit.aml.co.jp/member/interview/veteran02.html', 8, 19, '2014-11-08 01:26:49', '2014-11-08 01:26:49');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(38, '先輩社員インタビュー 吉田 三紀｜青山メインランド新卒採用スペシャルサイト', 'http://recruit.aml.co.jp/member/interview/senior01.html', 8, 19, '2014-11-08 01:27:14', '2014-11-08 01:27:14');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(39, '先輩社員インタビュー 山崎 未央｜青山メインランド新卒採用スペシャルサイト', 'http://recruit.aml.co.jp/member/interview/senior03.html', 8, 19, '2014-11-08 01:27:44', '2014-11-08 01:27:44');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(40, '宮﨑 ゆい｜社員インタビュー｜RCO リクルートコミュニケーションズ - RECRUIT COMMUNICATIONS', 'http://www.rco.recruit.co.jp/new/pre_human/miyazaki.php', 8, 20, '2014-11-08 01:29:27', '2014-11-08 01:29:27');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(41, '宮城 愛｜社員インタビュー｜RCO リクルートコミュニケーションズ - RECRUIT COMMUNICATIONS', 'http://www.rco.recruit.co.jp/new/pre_human/miyagi.php', 8, 20, '2014-11-08 01:30:16', '2014-11-08 01:30:16');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(42, '社員インタビュー | 採用 | 株式会社Cygames', 'http://www.cygames.co.jp/recruit/interview06.html', 1, 21, '2014-11-08 01:32:10', '2014-11-08 01:32:10');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(43, '2年目社員の一日 - 冠 結衣（販売職／ソフトバンク クルー） | ソフトバンクグループ2015新卒採用', 'http://recruit.softbank.jp/graduate/senior/job/kammuri/', 1, 22, '2014-11-08 01:33:56', '2014-11-08 01:33:56');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(44, '新入社員の一日 - 大長 真梨（エンジニア職） | ソフトバンクグループ2015新卒採用', 'http://recruit.softbank.jp/graduate/senior/new/onaga/', 1, 22, '2014-11-08 01:34:21', '2014-11-08 01:34:21');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(45, '先輩社員インタビュー「清水 優花」 - 株式会社USEN 2015新卒採用サイト| USEN CORPRATION', 'http://www.usen.com/recruit/fresh2015/work/interview/senior6.html', 1, 23, '2014-11-08 01:36:19', '2014-11-08 01:36:19');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(46, '法務｜新卒採用情報｜花王株式会社｜', 'http://www.kao.co.jp/saiyo/graduates/monozukuri/legal03.html', 5, 24, '2014-11-08 01:39:52', '2014-11-08 01:39:52');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(47, '情報システム｜新卒採用情報｜花王株式会社｜', 'http://www.kao.co.jp/saiyo/graduates/monozukuri/system02.html', 5, 24, '2014-11-08 01:40:13', '2014-11-08 01:40:13');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(48, '情報システム｜新卒採用情報｜花王株式会社｜', 'http://www.kao.co.jp/saiyo/graduates/monozukuri/system03.html', 5, 24, '2014-11-08 01:40:35', '2014-11-08 01:40:35');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(49, 'コピーライター｜新卒採用情報｜花王株式会社｜', 'http://www.kao.co.jp/saiyo/graduates/monozukuri/copywriter04.html', 5, 24, '2014-11-08 01:40:56', '2014-11-08 01:40:56');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(50, 'マーケティング｜新卒採用情報｜花王株式会社｜', 'http://www.kao.co.jp/saiyo/graduates/monozukuri/mk05.html', 5, 24, '2014-11-08 01:41:54', '2014-11-08 01:41:54');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(51, 'SEOコンサルタント | 株式会社サイバーエージェント', 'https://www.cyberagent.co.jp/recruit/interview/detail/id=4013', 1, 25, '2014-11-08 01:43:29', '2014-11-08 01:43:29');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(52, '社員インタビュー｜株式会社マクロミル採用サイト', 'http://www.macromill.com/recruit/interview_detail.html?p=2', 1, 26, '2014-11-08 01:44:35', '2014-11-08 01:44:35');
INSERT INTO `site` (`site_id`, `title`, `url`, `category_id`, `company_id`, `create_date`, `update_date`) VALUES(53, '社員インタビュー｜株式会社マクロミル採用サイト', 'http://www.macromill.com/recruit/interview_detail.html?p=10', 1, 26, '2014-11-08 01:45:10', '2014-11-08 01:45:10');

--
-- テーブルのデータのダンプ `tag`
--

INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(1, '男性', '2014-03-15 23:14:32', '2014-03-15 23:14:32');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(2, '女性', '2014-03-15 23:14:32', '2014-03-15 23:14:32');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(3, '営業', '2014-03-15 23:15:05', '2014-03-15 23:15:05');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(4, '技術', '2014-03-15 23:15:05', '2014-03-15 23:15:05');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(5, '専門職', '2014-03-15 23:15:42', '2014-03-15 23:15:42');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(6, '販売', '2014-03-15 23:15:42', '2014-03-15 23:15:42');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(7, 'サービス', '2014-03-15 23:17:53', '2014-03-15 23:17:53');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(8, '企画', '2014-03-15 23:17:53', '2014-03-15 23:17:53');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(9, '事務', '2014-03-15 23:17:53', '2014-03-15 23:17:53');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(10, 'クリエイティブ', '2014-03-15 23:17:53', '2014-03-15 23:17:53');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(11, '人事', '2014-03-15 23:18:17', '2014-03-15 23:18:17');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(12, '総務', '2014-03-15 23:18:17', '2014-03-15 23:18:17');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(13, '中途', '2014-03-15 23:18:53', '2014-03-15 23:18:53');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(14, '新卒', '2014-03-15 23:18:53', '2014-03-15 23:18:53');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(15, 'インターン', '2014-03-15 23:20:53', '2014-03-15 23:20:53');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(16, '2015年', '2014-03-20 00:19:51', '2014-03-20 00:19:51');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(20, 'JINS', '2014-03-25 00:16:01', '2014-03-25 00:16:01');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(21, 'メガネ', '2014-03-25 00:16:01', '2014-03-25 00:16:01');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(22, '技術系', '2014-03-27 23:06:18', '2014-03-27 23:06:18');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(23, '事務系', '2014-03-27 23:49:23', '2014-03-27 23:49:23');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(24, '医療', '2014-04-09 00:57:16', '2014-04-09 00:57:16');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(25, 'Webデザイナー', '2014-11-07 23:37:40', '2014-11-07 23:37:40');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(26, 'SEOコンサルタント', '2014-11-07 23:37:56', '2014-11-07 23:37:56');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(27, 'RD', '2014-11-07 23:39:00', '2014-11-07 23:39:00');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(28, 'コンベンショナルRD', '2014-11-07 23:39:32', '2014-11-07 23:39:32');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(29, '集計', '2014-11-07 23:40:07', '2014-11-07 23:40:07');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(30, 'プロダクトマネジャー', '2014-11-08 00:00:11', '2014-11-08 00:00:11');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(31, 'Web職種', '2014-11-08 00:00:11', '2014-11-08 00:00:11');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(32, 'マーケティング', '2014-11-08 00:48:11', '2014-11-08 00:48:11');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(33, '研究開発', '2014-11-08 00:48:59', '2014-11-08 00:48:59');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(34, '管理', '2014-11-08 00:49:23', '2014-11-08 00:49:23');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(35, 'コンサルタント', '2014-11-08 00:52:41', '2014-11-08 00:52:41');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(36, '不動産', '2014-11-08 00:53:16', '2014-11-08 00:53:16');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(37, '経理', '2014-11-08 00:53:42', '2014-11-08 00:53:42');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(38, '秘書', '2014-11-08 00:53:42', '2014-11-08 00:53:42');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(39, 'ネイルサロン', '2014-11-08 00:54:00', '2014-11-08 00:54:00');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(40, 'システム開発', '2014-11-08 00:54:20', '2014-11-08 00:54:20');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(41, 'オペレーション', '2014-11-08 01:01:08', '2014-11-08 01:01:08');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(42, '自動車事業', '2014-11-08 01:02:54', '2014-11-08 01:02:54');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(43, 'ブライダル事業', '2014-11-08 01:03:24', '2014-11-08 01:03:24');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(44, 'ネットビジネス', '2014-11-08 01:04:12', '2014-11-08 01:04:12');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(45, 'イシュイング', '2014-11-08 01:06:51', '2014-11-08 01:06:51');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(46, '管財', '2014-11-08 01:07:44', '2014-11-08 01:07:44');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(47, '営業コンサルタント', '2014-11-08 01:07:59', '2014-11-08 01:07:59');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(48, 'サービス企画', '2014-11-08 01:09:06', '2014-11-08 01:09:06');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(49, '輸入通関', '2014-11-08 01:09:38', '2014-11-08 01:09:38');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(50, '介護福祉士', '2014-11-08 01:10:39', '2014-11-08 01:10:39');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(51, '編集', '2014-11-08 01:13:15', '2014-11-08 01:13:15');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(52, 'プロデューサー', '2014-11-08 01:14:59', '2014-11-08 01:14:59');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(53, 'セールス・トレーディング', '2014-11-08 01:17:15', '2014-11-08 01:17:15');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(54, 'ITプランナー', '2014-11-08 01:30:16', '2014-11-08 01:30:16');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(55, 'エンジニア', '2014-11-08 01:34:21', '2014-11-08 01:34:21');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(56, '法務', '2014-11-08 01:39:52', '2014-11-08 01:39:52');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(57, '情報システム', '2014-11-08 01:40:13', '2014-11-08 01:40:13');
INSERT INTO `tag` (`tag_id`, `title`, `create_date`, `update_date`) VALUES(58, 'コピーライター', '2014-11-08 01:40:56', '2014-11-08 01:40:56');

--
-- テーブルのデータのダンプ `tag_site_map`
--

INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(1, 30, 1, '2014-11-08 00:00:11', '2014-11-08 00:00:11');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(2, 31, 1, '2014-11-08 00:00:11', '2014-11-08 00:00:11');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(3, 32, 24, '2014-11-08 00:48:11', '2014-11-08 00:48:11');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(4, 3, 25, '2014-11-08 00:48:35', '2014-11-08 00:48:35');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(5, 33, 26, '2014-11-08 00:48:59', '2014-11-08 00:48:59');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(6, 34, 27, '2014-11-08 00:49:23', '2014-11-08 00:49:23');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(7, 32, 23, '2014-11-08 00:51:40', '2014-11-08 00:51:40');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(8, 3, 22, '2014-11-08 00:51:58', '2014-11-08 00:51:58');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(9, 35, 21, '2014-11-08 00:52:41', '2014-11-08 00:52:41');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(10, 36, 20, '2014-11-08 00:53:16', '2014-11-08 00:53:16');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(11, 37, 19, '2014-11-08 00:53:42', '2014-11-08 00:53:42');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(12, 38, 19, '2014-11-08 00:53:42', '2014-11-08 00:53:42');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(13, 39, 18, '2014-11-08 00:54:00', '2014-11-08 00:54:00');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(14, 40, 17, '2014-11-08 00:54:20', '2014-11-08 00:54:20');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(15, 41, 16, '2014-11-08 01:01:08', '2014-11-08 01:01:08');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(16, 42, 2, '2014-11-08 01:02:54', '2014-11-08 01:02:54');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(17, 43, 3, '2014-11-08 01:03:24', '2014-11-08 01:03:24');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(18, 44, 4, '2014-11-08 01:04:12', '2014-11-08 01:04:12');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(19, 32, 5, '2014-11-08 01:04:28', '2014-11-08 01:04:28');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(20, 3, 6, '2014-11-08 01:04:48', '2014-11-08 01:04:48');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(21, 3, 7, '2014-11-08 01:05:52', '2014-11-08 01:05:52');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(22, 32, 8, '2014-11-08 01:06:10', '2014-11-08 01:06:10');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(23, 45, 9, '2014-11-08 01:06:51', '2014-11-08 01:06:51');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(24, 3, 10, '2014-11-08 01:07:27', '2014-11-08 01:07:27');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(25, 46, 11, '2014-11-08 01:07:44', '2014-11-08 01:07:44');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(26, 47, 12, '2014-11-08 01:07:59', '2014-11-08 01:07:59');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(27, 48, 13, '2014-11-08 01:09:06', '2014-11-08 01:09:06');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(28, 3, 14, '2014-11-08 01:09:21', '2014-11-08 01:09:21');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(29, 49, 15, '2014-11-08 01:09:38', '2014-11-08 01:09:38');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(30, 50, 28, '2014-11-08 01:10:39', '2014-11-08 01:10:39');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(31, 11, 29, '2014-11-08 01:12:25', '2014-11-08 01:12:25');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(32, 51, 30, '2014-11-08 01:13:15', '2014-11-08 01:13:15');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(33, 52, 31, '2014-11-08 01:14:59', '2014-11-08 01:14:59');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(34, 53, 32, '2014-11-08 01:17:15', '2014-11-08 01:17:15');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(35, 3, 33, '2014-11-08 01:17:47', '2014-11-08 01:17:47');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(36, 3, 34, '2014-11-08 01:21:39', '2014-11-08 01:21:39');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(37, 3, 35, '2014-11-08 01:23:12', '2014-11-08 01:23:12');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(38, 12, 36, '2014-11-08 01:24:08', '2014-11-08 01:24:08');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(39, 3, 37, '2014-11-08 01:26:49', '2014-11-08 01:26:49');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(40, 3, 38, '2014-11-08 01:27:14', '2014-11-08 01:27:14');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(41, 3, 39, '2014-11-08 01:27:44', '2014-11-08 01:27:44');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(42, 11, 40, '2014-11-08 01:29:27', '2014-11-08 01:29:27');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(43, 54, 41, '2014-11-08 01:30:16', '2014-11-08 01:30:16');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(44, 11, 42, '2014-11-08 01:32:10', '2014-11-08 01:32:10');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(45, 6, 43, '2014-11-08 01:33:56', '2014-11-08 01:33:56');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(46, 55, 44, '2014-11-08 01:34:21', '2014-11-08 01:34:21');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(47, 3, 45, '2014-11-08 01:36:19', '2014-11-08 01:36:19');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(48, 56, 46, '2014-11-08 01:39:52', '2014-11-08 01:39:52');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(49, 57, 47, '2014-11-08 01:40:13', '2014-11-08 01:40:13');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(50, 57, 48, '2014-11-08 01:40:35', '2014-11-08 01:40:35');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(51, 58, 49, '2014-11-08 01:40:56', '2014-11-08 01:40:56');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(52, 32, 50, '2014-11-08 01:41:54', '2014-11-08 01:41:54');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(53, 26, 51, '2014-11-08 01:43:29', '2014-11-08 01:43:29');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(54, 27, 52, '2014-11-08 01:44:35', '2014-11-08 01:44:35');
INSERT INTO `tag_site_map` (`map_id`, `tag_id`, `site_id`, `create_date`, `update_date`) VALUES(55, 28, 53, '2014-11-08 01:45:10', '2014-11-08 01:45:10');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
