package cn.xujinchun.ofounlocker.dao;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import cn.xujinchun.ofounlocker.pojo.Tofo;

public class ActionDaoImpl implements IActionDao{
		// 声明日志对象
		private static Logger log = Logger.getLogger(ActionDaoImpl.class);

		// 声明mybatis操作数据库的会话对象
		private SqlSessionTemplate sqlSessionTemplate;

		public SqlSessionTemplate getSqlSessionTemplate() {
			return sqlSessionTemplate;
		}

		public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
			this.sqlSessionTemplate = sqlSessionTemplate;
		}
		
		public void queryAll(){
			log.info("[Class]ActionDaoImpl [Method]queryAll is starting......");
			
		}
		
		public Tofo queryByBicycleID(String bicycleid){
			log.info("[Class]ActionDaoImpl [Method]queryByBicycleID is starting......");
			log.info("sqlSessionTemplate-----" + sqlSessionTemplate);
			
			Tofo ofo = null;
			try{
				Object resultObj = this.sqlSessionTemplate.selectOne("cn.xujinchun.ofounlocker.ofo.queryByBicycleId",bicycleid);
				
				if(resultObj != null || "".equals(resultObj)){
					ofo = (Tofo) resultObj;
				}
				log.info("【Success】 [Class]ActionDaoImpl [Method]queryAll [mymatis query operation success]");
			}catch (Exception e) {
				e.printStackTrace();
				log.warn("【Wrong】 [Class]ActionDaoImpl [Method]insert [mymatis insert operation wrong]");
			}
			
			return  ofo;
		}

		public int insert(String bicycleid, String password) {
			log.info("[Class]ActionDaoImpl [Method]insert is starting......");
			
			log.info("sqlSessionTemplate-----" + sqlSessionTemplate);
			
			Tofo ofo = new Tofo(bicycleid, password);
			int n = 0;
			try{
				n = this.sqlSessionTemplate.insert("cn.xujinchun.ofounlocker.ofo.insert",ofo);
				log.info("【Success】 [Class]ActionDaoImpl [Method]insert [mymatis insert operation success]");
			}catch (Exception e) {
				e.printStackTrace();
				log.warn("【Wrong】 [Class]ActionDaoImpl [Method]insert [mymatis insert operation wrong]");
			}
			
			return n;
			
		}
		
		public int update(String bicycleid, String password) {
			log.info("[Class]ActionDaoImpl [Method]update is starting......");
			
			log.info("sqlSessionTemplate-----" + sqlSessionTemplate);
			
			Tofo ofo = new Tofo(bicycleid, password);
			int n = 0;
			try{
				n = this.sqlSessionTemplate.update("cn.xujinchun.ofounlocker.ofo.update",ofo);
				log.info("【Success】 [Class]ActionDaoImpl [Method]insert [mymatis insert operation success]");
			}catch (Exception e) {
				e.printStackTrace();
				log.warn("【Wrong】 [Class]ActionDaoImpl [Method]insert [mymatis insert operation wrong]");
			}
			
			return n;
			
		}
		
		
}
