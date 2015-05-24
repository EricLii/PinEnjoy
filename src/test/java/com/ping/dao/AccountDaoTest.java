package com.ping.dao;

import com.tianex.pinenjoy.dao.AccountDao;
import com.tianex.pinenjoy.domain.Account;
import junit.framework.Assert;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBean;

/**
 * �û��˻�������
 * @author eric
 */
public class AccountDaoTest extends BaseDaoTest {

    @SpringBean("accountDao")
    private AccountDao accountDao;

    /**
     * ��������û�ģ��
     */
    @Test
    @ExpectedDataSet("pp.ExpectedAccount.xls")
    public void addAccount() {
        //List<Account> accounts = XlsDataSetBeanFactory.createBeas();

        //for (Account account : accounts) {
            //accountDao.save(account);
        //}
    }

    /**
     * ����ɾ���û�ģ��
     */
    @Test
    @DataSet("pp.account.xls") //׼����������
    @ExpectedDataSet("pp.expectedAccount.xls") //׼����֤��������
    public void removeAccount() {
        Account account = accountDao.get(3);
        accountDao.delete(account);
    }

    /**
     * ���Լ���ģ��
     */
    @Test
    @DataSet("pp.account.xls")
    public void getAccount() {
        Account account = accountDao.load(1);

        //��֤���
        Assert.assertNotNull(account);
        //Assert.assertThat(account.getNickName(), Matchers.containsString(""));
    }


}
